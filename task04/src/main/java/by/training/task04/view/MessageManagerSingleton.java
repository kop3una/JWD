package by.training.task04.view;

public class MessageManagerSingleton { // TODO не нужно
    private static MessageManagerSingleton instance;
    MessageManager currentLang = MessageManager.DEFAULT;

    private MessageManagerSingleton(){}

    public static MessageManagerSingleton getInstance(){
        if(instance == null) {
            instance = new MessageManagerSingleton();
        }
        return instance;
    }

    public String getString(String key) {
        return currentLang.getString(key);
    }

    public String getCountry() {
        return currentLang.getCountry();
    }

    public void setEnglish() {
        currentLang = MessageManager.EN;
    }

    public void setBelarusian() {
        currentLang = MessageManager.BY;
    }

    public void setRussian() {
        currentLang = MessageManager.RU;
    }
}
