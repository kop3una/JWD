package by.training.task04.view;

import by.training.task04.beans.Result;
import by.training.task04.beans.Text;
import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Scanner;

public class View {
    private static final String ERROR_INPUT = "Некорректный ввод";
    private static final char DELIMITER = ' ';
    private static final char DELIMITER_UNDERSСORE = '_';
    private static final char DELIMITER_ARGS = (char) 1;
    //  private static final Controller controller = new Controller();
    private static final Logger logger = (Logger) LogManager.getLogger(View.class);
    private static String currentLang = "RU";
    private static final Controller controller = new Controller(currentLang);

    private static String choice() {
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    private static void mainMenu() {
        System.out.println(MessageManagerSingleton.getInstance().getString("mainMenu"));
    }

    private static String nameFileForRead() {
        System.out.print(MessageManagerSingleton.getInstance().getString("nameFileForRead"));
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    private static String nameFileForWrite() {
        System.out.print(MessageManagerSingleton.getInstance().getString("nameFileForWrite"));
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    private static String addSentenceToText() {
        System.out.print(MessageManagerSingleton.getInstance().getString("addSentenceToText"));
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    private static void textMenu() {
        System.out.println(MessageManagerSingleton.getInstance().getString("textMenu"));
    }

    private static void text(Result result) {
        var answer = "0";
        var exit = "5";

        do {
            textMenu();
            switch (answer = choice()) {
                case "1": {
                    if (result.getText().getHeader().isEmpty()){
                        System.out.println(MessageManagerSingleton.getInstance().getString("emptyHeader"));
                    } else {
                        System.out.println(MessageManagerSingleton.getInstance().getString("header") + result.getText().getHeader());
                    }

                    if (result.getText().getBody().isEmpty()){
                        System.out.println(MessageManagerSingleton.getInstance().getString("emptyText"));
                    } else {
                        System.out.println(result.getText().getBody());
                    }
                    break;
                }
                case "2": {
                    String sentence = addSentenceToText();
                    controller.setText(result);
                    result = controller.executeTask("TEXT_ADD" + DELIMITER + sentence);
                    break;
                }
                case "3": {
                    System.out.println(MessageManagerSingleton.getInstance().getString("header") + result.getText().getHeader());
                    break;
                }
                case "4": {
                    String fileName = nameFileForWrite();
                    controller.setText(result);
                    result = controller.executeTask("TEXT_WRITE" + DELIMITER + fileName);
                    if (!result.isState()){
                        System.out.println(MessageManagerSingleton.getInstance().getString("errorWrite"));
                        logger.warn(MessageManagerSingleton.getInstance().getString("errorWrite"));
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (!answer.equals(exit));
    }

    public void startView() {
        var answer = "0";
        var exit = "3";
        while (!answer.equals(exit)) {
            mainMenu();
            switch (answer = choice()){
                case "1" : {
                    String fileName = nameFileForRead();
                    Result result = controller.executeTask("TEXT_READ" + DELIMITER + fileName);
                    if (result.isState()) {
                        text(result);
                    } else {
                        System.out.println(MessageManagerSingleton.getInstance().getString("errorRead"));
                        logger.warn(MessageManagerSingleton.getInstance().getString("errorRead"));
                    }
                    break;
                }
                case "2" : {
                    String fileName = nameFileForWrite();
                    Result result = controller.executeTask("TEXT_GENERATE" + DELIMITER + fileName);
                    if (result.isState()) {
                        text(result);
                    } else {
                        System.out.println(MessageManagerSingleton.getInstance().getString("errorGenerate"));
                        logger.warn(MessageManagerSingleton.getInstance().getString("errorGenerate"));
                    }
                    break;
                }
                case "3": {
                    answer = "3";
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

}
