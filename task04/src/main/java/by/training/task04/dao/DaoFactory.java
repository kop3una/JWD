package by.training.task04.dao;

import by.training.task04.dao.impl.FileTextDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final TextDao textImpl = new FileTextDao();

    private DaoFactory() {}
    public static DaoFactory getInstance(){
        return instance;
    }
    public TextDao getTextDao(){
        return textImpl;
    }
}
