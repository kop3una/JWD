package by.training.task05.dao.impl;

import by.training.task05.dao.DataDao;
import by.training.task05.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataDaoImpl implements DataDao {
    private final Logger logger = LogManager.getLogger(DataDaoImpl.class);
    @Override
    public List<String> readFromFile(String fileName) throws DaoException {
        Path path = Paths.get("src/main/resources/"+fileName+".txt").toAbsolutePath();
        try {
           return Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            logger.error(e);
            throw new DaoException(fileName + " File not found");
        }
    }
}
