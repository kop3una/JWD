package by.training.task08.services.validator;

import by.training.task08.services.handler.error.XMLErrorHandler;
import by.training.task08.services.exception.ServicesException;
import by.training.task08.servlets.XMLServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    private static Logger logger = LogManager.getLogger();

    public boolean isValid (String fileNameArg) throws ServicesException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String schemaName = "C:\\Users\\kiril\\OneDrive\\Рабочий стол\\Учеба\\JavaWeb\\task08\\out\\artifacts\\task08\\WEB-INF\\classes\\data\\candies.xsd";
        String fileName = fileNameArg;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        File file = new File(fileName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(file);
            validator.setErrorHandler(new XMLErrorHandler());
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e){
            logger.error(e);
            throw new ServicesException(e);
        }
    }
}
