package by.training.task08.services.handler.content;

import by.training.task08.beans.CandiesXmlTag;
import by.training.task08.beans.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandiesHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(CandiesHandler.class);
    private final Set<Candy> candies;
    private Candy current;
    private CandiesXmlTag currentXmlTag;
    private final EnumSet<CandiesXmlTag> withText;
    private static final String ELEMENT_CANDY = "candy";
    private CandiesXmlTag typeWeight;

    public CandiesHandler() {
        candies = new HashSet<>();
        withText = EnumSet.range(CandiesXmlTag.NAME, CandiesXmlTag.INGREDIENTS);
    }

    public Set<Candy> getCandies() {
        return candies;
    }


    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CANDY.equals(qName)) {
            current = new Candy();
            CandiesXmlTag temp = CandiesXmlTag.valueOf(attrs.getLocalName(0).toUpperCase());
            if (temp == CandiesXmlTag.COUNTRY){
                current.setCountry(attrs.getValue(0));
            } else {
                current.setPrice(attrs.getValue(0));
            }

            if (attrs.getLength() == 2) {
                temp = CandiesXmlTag.valueOf(attrs.getLocalName(1).toUpperCase());
                if (temp == CandiesXmlTag.COUNTRY){
                    current.setCountry(attrs.getValue(1));
                } else {
                    current.setPrice(attrs.getValue(1));
                }
            }
        } else {
            CandiesXmlTag temp = CandiesXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CANDY.equals(qName)) {
            candies.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case NAME: current.setName(processData(data)); break;
                case ENERGY: current.setEnergy(Integer.parseInt(data.trim())); break;
                case TYPE: current.setType(data.trim()); break;
                case PRODUCTION: current.setProduction(data.trim()); break;
                case DATE_MANUFACTURED: current.setDateManufactured(processDate(data)); break;

                case FATS: current.getValue().setFats(Double.parseDouble(data.trim())); break;
                case PROTEINS: current.getValue().setProteins(Double.parseDouble(data.trim())); break;
                case CARBOHYDRATES: current.getValue().setCarbohydrates(Double.parseDouble(data.trim())); break;

                case WATER: current.getIngredients().setWater(Integer.parseInt(data.trim())); break;
                case CARAMEL: current.getIngredients().setCaramel(Integer.parseInt(data.trim())); break;
                case SUGAR: current.getIngredients().setSugar(Integer.parseInt(data.trim())); break;
                case FRUCTOSE: current.getIngredients().setFructose(Integer.parseInt(data.trim())); break;
                case OIL: current.getIngredients().setOil(Integer.parseInt(data.trim())); break;
                case MILK: current.getIngredients().setMilk(Integer.parseInt(data.trim())); break;
                case SOURCREAM: current.getIngredients().setSourCream(Integer.parseInt(data.trim())); break;
                case CONDENSEDMILK: current.getIngredients().setCondensedMilk(Integer.parseInt(data.trim())); break;
                case EGGSPROTEIN: current.getIngredients().setEggsProtein(Integer.parseInt(data.trim())); break;
                case GELATIN: current.getIngredients().setGelatin(Integer.parseInt(data.trim())); break;

                case TYPECHOCOLATE: current.getIngredients().getChocolate().setTypeChocolate(data.trim()); break;
                case TYPENUTS: current.getIngredients().getNuts().setTypeNuts(data.trim()); break;

                case WEIGHT: {
                    if (typeWeight == CandiesXmlTag.CHOCOLATE){
                        current.getIngredients().getChocolate().setWeight(Integer.parseInt(data.trim()));
                    } else {
                        current.getIngredients().getNuts().setWeight(Integer.parseInt(data.trim()));
                    }
                    break;
                }
                case INGREDIENTS:
                case VALUE:
                    break;
                case CHOCOLATE: typeWeight = CandiesXmlTag.CHOCOLATE; break;
                case NUTS: typeWeight = CandiesXmlTag.NUTS; break;

                default:
                    logger.error(currentXmlTag.getDeclaringClass() + " " +currentXmlTag.name());
                    throw new EnumConstantNotPresentException(
                            currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

    private String processData (String element){
        return element.trim().replace('_',' ');
    }

    private String processDate(String date){
        return date.substring(8) + '-' +
                date.substring(5, 7) +
                '-' +
                date.substring(0, 4);
    }
}
