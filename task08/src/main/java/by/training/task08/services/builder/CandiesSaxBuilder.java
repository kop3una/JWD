package by.training.task08.services.builder;

import by.training.task08.beans.Candy;
import by.training.task08.services.handler.content.CandiesHandler;
import by.training.task08.services.handler.error.XMLErrorHandler;
import by.training.task08.services.exception.ServicesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class CandiesSaxBuilder {
    private static final Logger logger = LogManager.getLogger(CandiesSaxBuilder.class);
    private Set<Candy> candies;
    private final CandiesHandler handler = new CandiesHandler();
    private final XMLReader reader;
    public CandiesSaxBuilder() throws ServicesException {
        // reader configuration
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.error(e);
            throw new ServicesException(e);
            //e.printStackTrace(); // log
        }
        reader.setErrorHandler(new XMLErrorHandler());
        reader.setContentHandler(handler);
    }
    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String filename) throws ServicesException {
        try {
            File file = new File(filename);
            reader.parse(new InputSource(new FileInputStream(file)));
        } catch (IOException | SAXException e) {
            logger.error(e);
            throw new ServicesException(e);
        }
        candies = handler.getCandies();
    }
}
