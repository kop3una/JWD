package by.training.task06.dao;


import by.training.task06.dao.impl.FileInfoData;
import by.training.task06.dao.impl.FileMatrixDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final MatrixDao matrixDaoImpl = new FileMatrixDao();
    private final InfoDataDao infoDataDaoImpl = new FileInfoData();

    private DaoFactory() {}
    public static DaoFactory getInstance(){
        return instance;
    }
    public MatrixDao getMatrixDao(){
        return matrixDaoImpl;
    }
    public InfoDataDao getInfoDataDao() { return infoDataDaoImpl; }
}
