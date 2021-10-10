package by.training.task07.dao;

import by.training.task07.dao.impl.FileTextDao;
import by.training.task07.dao.impl.TextTestDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final TextDao textImpl = new FileTextDao();
    private final TextDao textTestImpl = new TextTestDao();

    private DaoFactory() {}
    public static DaoFactory getInstance(){
        return instance;
    }
    public TextDao getTextDao(){
        return textImpl;
    }
    public TextDao getTextTestDao() { return textTestImpl; }
}
