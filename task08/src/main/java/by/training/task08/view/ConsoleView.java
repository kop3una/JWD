package by.training.task08.view;

import by.training.task08.beans.Candy;
import by.training.task08.beans.Result;
import by.training.task08.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class ConsoleView {
    private static final String DELIMITER_ROWS_TABLE = "________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________";
    private static final char DELIMITER = ' ';
    private static final Logger logger = (Logger) LogManager.getLogger(ConsoleView.class);
    private static final Controller controller = new Controller();
    private static final Scanner in = new Scanner(System.in);

    private static String choice() {
        return in.nextLine();
    }

    private static void mainMenu() {
        System.out.println("1. Ввести имя файла \n"+
                           "2. Выход");
    }

    private static void choiceParserMenu(){
        System.out.println("Выберите парсер \n"+
                           "1. Dom \n"+
                           "2. Sax \n"+
                           "3. Stax \n" +
                           "4. Выход");
    }

    private static void tableVizualization (Set<Candy> candies){
        System.out.println(DELIMITER_ROWS_TABLE + "\n" +
                        "|Название            |Тип                 |Калории|Страна|Цена  |Жиры    |Белки   |Углеводы|Изготовитель                |Дата производства|Вода|Карамель|Сахар|Фруктоза|Тип Шоколада|Вес шоколада|Масло|Молоко|Сметана|Сгущенка|Яичный белок|Тип орехов     |Вес орехов|Желатин|\n" +
                DELIMITER_ROWS_TABLE);
        for (Candy candy : candies){
            System.out.printf("|%20s|%20s|%7d|%6s|%6s|%8.2f|%8.2f|%8.2f|%28s|%17s|%4d|%8d|%5d|%8d|%12s|%12d|%5d|%6d|%7d|%8d|%12d|%15s|%10d|%7d|\n", candy.getName(),candy.getType(),candy.getEnergy(),candy.getCountry(),candy.getPrice(),
                    candy.getValue().getFats(),candy.getValue().getProteins(),candy.getValue().getCarbohydrates(),candy.getProduction(),candy.getDateManufactured(),
                    candy.getIngredients().getWater(), candy.getIngredients().getCaramel(),candy.getIngredients().getSugar(),candy.getIngredients().getFructose(),
                    candy.getIngredients().getChocolate().getTypeChocolate(), candy.getIngredients().getChocolate().getWeight(),candy.getIngredients().getOil(),
                    candy.getIngredients().getMilk(),candy.getIngredients().getSourCream(), candy.getIngredients().getCondensedMilk(),candy.getIngredients().getEggsProtein(),
                    candy.getIngredients().getNuts().getTypeNuts(), candy.getIngredients().getNuts().getWeight(),candy.getIngredients().getGelatin()
            );
            System.out.println(DELIMITER_ROWS_TABLE);
        }

    }

    private String getFullFileName(String fileName){
        String path = new File("").getAbsolutePath();
        return path+ File.separator+ "src\\main\\resources\\data\\"+ fileName;
    }

    public void startView() {
        var answer = "0";
        var exit = "2";
        Result result = new Result();
        while (!answer.equals(exit)) {
            mainMenu();
            switch (answer = choice()){
                case "1" : {
                    //System.out.print("Введите имя файла: ");
                    //String fileName = in.nextLine();
                    String fileName = getFullFileName("candies.xml");

                    //choiceParserMenu();
                    //String parser = choice();
                    String parser = "2";
                    switch (parser){
                        case "1" : result = controller.executeTask("DOM" + DELIMITER +fileName); break;
                        case "2" : result = controller.executeTask("SAX" + DELIMITER +fileName); break;
                        case "3" : result = controller.executeTask("STAX" + DELIMITER +fileName); break;
                        default: break;
                    }
                    if (result.isState()){
                        tableVizualization(result.getCandies());
                    } else {
                        System.out.println("Что-то пошло не так, проверьте файл");
                    }
                    break;
                }
                case "2" : {
                    answer = "2";
                }
                default: {
                    break;
                }
            }
        }
    }

}
