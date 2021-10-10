package by.training.task08.services.builder;

import by.training.task08.beans.Candy;
import by.training.task08.services.exception.ServicesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CandiesDomBuilder {
    private static final Logger logger = LogManager.getLogger(CandiesDomBuilder.class);
    private final Set<Candy> candies;
    private final DocumentBuilder docBuilder;
    public CandiesDomBuilder() throws ServicesException {
        candies = new HashSet<>();
        // configuration
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
            throw new ServicesException(e);
        }
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void buildSetCandies(String filename) throws ServicesException {
        Document doc;
        try {
            File file = new File(filename);
            doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();
            // getting a list of <candy> child elements
            NodeList candiesList = root.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException | SAXException e) {
            logger.error(e);
            throw new ServicesException(e); // log
        }
    }
    private Candy buildCandy(Element candyElement) {
        Candy candy = new Candy();
        candy.setCountry(candyElement.getAttribute("country"));
        if (candyElement.hasAttribute("price")){
            candy.setPrice(candyElement.getAttribute("price"));
        }
        candy.setName(processElement(getElementTextContent(candyElement,"name")));
        int energy = Integer.parseInt(processElement(getElementTextContent(candyElement,"energy")));
        candy.setEnergy(energy);
        candy.setType(processElement(getElementTextContent(candyElement,"type")));
        candy.setProduction(processElement(getElementTextContent(candyElement,"production")));
        String date = processElement(getElementTextContent(candyElement,"date_manufactured"));
        candy.setDateManufactured(processDate(date));

        Element valueElement = (Element) candyElement.getElementsByTagName("value").item(0);
        Candy.Value value = candy.getValue();
        double proteins = Double.parseDouble(processElement(getElementTextContent(valueElement,"proteins")));
        value.setProteins(proteins);
        double fats = Double.parseDouble(processElement(getElementTextContent(valueElement,"fats")));
        value.setFats(fats);
        double carbohydrates = Double.parseDouble(processElement(getElementTextContent(valueElement,"carbohydrates")));
        value.setCarbohydrates(carbohydrates);

        Element ingredientElement = (Element) candyElement.getElementsByTagName("ingredients").item(0);
        Candy.Ingredients ingredient = candy.getIngredients();
        int water = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"water")));
        ingredient.setWater(water);
        int caramel = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"caramel")));
        ingredient.setCaramel(caramel);
        int sugar = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"sugar")));
        ingredient.setSugar(sugar);
        int fructose = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"fructose")));
        ingredient.setFructose(fructose);
        int oil = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"oil")));
        ingredient.setOil(oil);
        int milk = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"milk")));
        ingredient.setMilk(milk);
        int sourCream = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"sourCream")));
        ingredient.setSourCream(sourCream);
        int condensedMilk = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"condensedMilk")));
        ingredient.setCondensedMilk(condensedMilk);
        int eggsProtein = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"eggsProtein")));
        ingredient.setEggsProtein(eggsProtein);
        int gelatin = Integer.parseInt(processElement(getElementTextContent(ingredientElement,"gelatin")));
        ingredient.setGelatin(gelatin);

        Element chocolateElement = (Element) ingredientElement.getElementsByTagName("chocolate").item(0);
        if (chocolateElement != null){
            Candy.Ingredients.Chocolate chocolate = ingredient.getChocolate();
            chocolate.setTypeChocolate(processElement(getElementTextContent(chocolateElement,"typeChocolate")));
            int chocolateWeight = Integer.parseInt(processElement(getElementTextContent(chocolateElement,"weight")));
            chocolate.setWeight(chocolateWeight);
        }


        Element nutsElement = (Element) ingredientElement.getElementsByTagName("nuts").item(0);
        if (nutsElement != null){
            Candy.Ingredients.Nuts nut = ingredient.getNuts();
            nut.setTypeNuts(processElement(getElementTextContent(nutsElement,"typeNuts")));
            int nutWeight = Integer.parseInt(processElement(getElementTextContent(nutsElement,"weight")));
            nut.setWeight(nutWeight);
        }
        return candy;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        if (nList.getLength() != 0){
            Node node = nList.item(0);
            return node.getTextContent();
        } else {
            return "0";
        }

    }

    private String processElement (String element){
        return element.trim().replace('_',' ');
    }

    private String processDate(String date){
        return date.substring(8) + '-' +
                date.substring(5, 7) +
                '-' +
                date.substring(0, 4);
    }
}
