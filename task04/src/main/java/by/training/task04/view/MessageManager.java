package by.training.task04.view;

import java.util.Locale;
import java.util.ResourceBundle;
public enum MessageManager {
    RU(ResourceBundle.getBundle("resources", new Locale("ru", "RU"))),
    EN(ResourceBundle.getBundle("resources", new Locale("en", "EN"))),
    BY(ResourceBundle.getBundle("resources", new Locale("be", "BY"))),
    DEFAULT(ResourceBundle.getBundle("resources", Locale.getDefault()));
    private final ResourceBundle bundle;
    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }
    public String getString(String key) {
        return bundle.getString(key);
    }
    public String getCountry() {
        return bundle.getLocale().getCountry();
    }
}