package by.training.task04.services.manager;

import by.training.task04.services.manager.impl.TextManagerImpl;

public class ManagerFactory {
    private static final ManagerFactory instance = new ManagerFactory();
    private final TextManager textManagerImpl = new TextManagerImpl();

    private ManagerFactory() {
    }

    public static ManagerFactory getInstance() {
        return instance;
    }

    public TextManager getTextManager() {
        return textManagerImpl;
    }
}
