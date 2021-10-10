package by.training.task04.view;

import java.util.Scanner;

public class ChoiceLang {

    public String getLanguage() {
        System.out.print(MessageManagerSingleton.getInstance().getString("choiceLang"));
        return changeLang(choice());
    }

    private String choice() {
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    private String changeLang(String choice) {
        switch (choice){
            case "1" : {
                MessageManagerSingleton.getInstance().setRussian();
                return "RU";
            }
            case "2" : {
                MessageManagerSingleton.getInstance().setEnglish();
                return "EN";
            }
            case "3" : {
                MessageManagerSingleton.getInstance().setBelarusian();
                return "BY";
            }
            default: {
                return "";
            }
        }
    }

}
