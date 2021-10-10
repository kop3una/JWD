package by.training.task07.dao.impl;

import by.training.task07.dao.TextDao;
import by.training.task07.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextTestDao implements TextDao {
    private static final int EOF = -1;
    private final Logger logger = LogManager.getLogger(FileTextDao.class);

    @Override
    public String readFromFile(String fileName) throws DaoException {
        Path path = Paths.get("src/test/resources/"+fileName+".txt").toAbsolutePath();
        try (FileReader fileReader = new FileReader(path.toString())) {
            int currentSymbol;
            StringBuilder buffer = new StringBuilder();
            while ((currentSymbol = fileReader.read()) != EOF) {
                buffer.append((char) currentSymbol);
            }
            return buffer.toString();
        } catch (IOException e) {
//            System.out.println(e);
            logger.error(e);
            throw new DaoException(fileName + " File not found");
        }
    }
}
