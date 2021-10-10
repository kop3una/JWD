package by.training.task05.dao;

import by.training.task05.dao.impl.DataDaoImpl;
import by.training.task05.dao.impl.DataDaoTestImpl;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final DataDao dataImpl = new DataDaoImpl();
    private final DataDao dataTestImpl = new DataDaoTestImpl();

    private DaoFactory() {}
    public static DaoFactory getInstance(){
        return instance;
    }
    public DataDao getTextDao(){
        return dataImpl;
    }
    public DataDao getTextTestDao(){
        return dataTestImpl;
    }
}
