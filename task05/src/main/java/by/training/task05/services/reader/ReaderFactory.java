package by.training.task05.services.reader;


import by.training.task05.services.reader.impl.DataReaderImpl;
import by.training.task05.services.reader.impl.DataReaderTestImpl;

public class ReaderFactory {
    private static final ReaderFactory instance = new ReaderFactory();
    private final DataReader dataReaderImpl = new DataReaderImpl();
    private final DataReader dataReaderTestImpl = new DataReaderTestImpl();

    private ReaderFactory() {
    }

    public static ReaderFactory getInstance() {
        return instance;
    }

    public DataReader getDataReader() {
        return dataReaderImpl;
    }
    public DataReader getDataReaderTest() {
        return dataReaderTestImpl;
    }
}
