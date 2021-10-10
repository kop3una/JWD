package by.training.task08.services.builder;

import by.training.task08.beans.CandiesXmlTag;
import by.training.task08.beans.Candy;
import by.training.task08.services.exception.ServicesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CandiesStaxBuilder {
    private static final Logger logger = LogManager.getLogger(CandiesStaxBuilder.class);
    private final Set<Candy> candies;
    private final XMLInputFactory inputFactory;

    public CandiesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String filename) throws ServicesException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(CandiesXmlTag.CANDY.getValue())) {
                        Candy candy = buildCandy(reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            logger.error(e);
            throw new ServicesException(e);
        }
    }

    private Candy buildCandy(XMLStreamReader reader)
            throws ServicesException {
        Candy candy = new Candy();
        if (reader.getAttributeCount() == 2) {
            candy.setPrice(reader.getAttributeValue(null, CandiesXmlTag.PRICE.getValue()));
        }
        candy.setCountry(reader.getAttributeValue(null,CandiesXmlTag.COUNTRY.getValue()));
        String name;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        name = reader.getLocalName();
                        switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                            case NAME:
                                candy.setName(processName(getXMLText(reader)));
                                break;
                            case ENERGY:
                                candy.setEnergy(Integer.parseInt(getXMLText(reader)));
                                break;
                            case TYPE:
                                candy.setType(getXMLText(reader));
                                break;
                            case PRODUCTION:
                                candy.setProduction(getXMLText(reader));
                                break;
                            case DATE_MANUFACTURED:
                                candy.setDateManufactured(processDate(getXMLText(reader)));
                                break;
                            case VALUE:
                                getXMLValue(reader, candy);
                                break;
                            case INGREDIENTS:
                                getXMLIngredients(reader,candy);
                                break;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        name = reader.getLocalName();
                        if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.CANDY) {
                            return candy;
                        }
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error(e);
          throw new ServicesException(e);
        }
        return candy;
    }

    private void getXMLValue(XMLStreamReader reader, Candy candy) throws ServicesException {
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        name = reader.getLocalName();
                        switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                            case FATS:
                                candy.getValue().setFats(Double.parseDouble(getXMLText(reader)));
                                break;
                            case PROTEINS:
                                candy.getValue().setProteins(Double.parseDouble(getXMLText(reader)));
                                break;
                            case CARBOHYDRATES:
                                candy.getValue().setCarbohydrates(Double.parseDouble(getXMLText(reader)));
                                break;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        name = reader.getLocalName();
                        if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.VALUE) {
                            return;
                        }
                    }
                }
            }
        } catch (XMLStreamException e){
            logger.error(e);
            throw new ServicesException(e);
        }
    }

    private void getXMLIngredients(XMLStreamReader reader, Candy candy) throws ServicesException {
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        name = reader.getLocalName();
                        switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                            case WATER: candy.getIngredients().setWater(Integer.parseInt(getXMLText(reader))); break;
                            case CARAMEL: candy.getIngredients().setCaramel(Integer.parseInt(getXMLText(reader))); break;
                            case SUGAR: candy.getIngredients().setSugar(Integer.parseInt(getXMLText(reader))); break;
                            case FRUCTOSE: candy.getIngredients().setFructose(Integer.parseInt(getXMLText(reader))); break;
                            case OIL: candy.getIngredients().setOil(Integer.parseInt(getXMLText(reader))); break;
                            case MILK: candy.getIngredients().setMilk(Integer.parseInt(getXMLText(reader))); break;
                            case SOURCREAM: candy.getIngredients().setSourCream(Integer.parseInt(getXMLText(reader))); break;
                            case CONDENSEDMILK: candy.getIngredients().setCondensedMilk(Integer.parseInt(getXMLText(reader))); break;
                            case EGGSPROTEIN: candy.getIngredients().setEggsProtein(Integer.parseInt(getXMLText(reader))); break;
                            case GELATIN: candy.getIngredients().setGelatin(Integer.parseInt(getXMLText(reader))); break;
                            case CHOCOLATE: getXMLChocolate(reader,candy); break;
                            case NUTS: getXMLNuts(reader,candy); break;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        name = reader.getLocalName();
                        if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.INGREDIENTS) {
                            return;
                        }
                    }
                }
            }
        } catch (XMLStreamException e){
            logger.error(e);
            throw new ServicesException(e);
        }
    }

    private void getXMLChocolate(XMLStreamReader reader, Candy candy) throws ServicesException {
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        name = reader.getLocalName();
                        switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                            case TYPECHOCOLATE: candy.getIngredients().getChocolate().setTypeChocolate(getXMLText(reader)); break;
                            case WEIGHT: candy.getIngredients().getChocolate().setWeight(Integer.parseInt(getXMLText(reader))); break;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        name = reader.getLocalName();
                        if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.CHOCOLATE) {
                            return;
                        }
                    }
                }
            }
        } catch (XMLStreamException e){
            logger.error(e);
            throw new ServicesException(e);
        }
    }

    private void getXMLNuts(XMLStreamReader reader, Candy candy) throws ServicesException {
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        name = reader.getLocalName();
                        switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                            case TYPENUTS: candy.getIngredients().getNuts().setTypeNuts(getXMLText(reader)); break;
                            case WEIGHT: candy.getIngredients().getNuts().setWeight(Integer.parseInt(getXMLText(reader))); break;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        name = reader.getLocalName();
                        if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.NUTS) {
                            return;
                        }
                    }
                }
            }
        } catch (XMLStreamException e){
            logger.error(e);
            throw new ServicesException(e);
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText().trim();
        }
        return text;
    }

    private String processName(String element) {
        return element.trim().replace('_', ' ');
    }

    private String processDate(String date) {
        return date.substring(8) + '-' +
                date.substring(5, 7) +
                '-' +
                date.substring(0, 4);
    }
}
