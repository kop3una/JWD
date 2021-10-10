package by.training.task04.dao.impl;

import by.training.task04.beans.Text;
import by.training.task04.dao.TextDao;
import by.training.task04.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FileTextDao implements TextDao {
    private static final int EOF = -1;
    private final Logger logger = LogManager.getLogger(FileTextDao.class);
    private static final String HEADER = "Заголовок:";

    @Override
    public void writeInFile(Text text, String fileName) throws DaoException {
        Path path = Paths.get(fileName).toAbsolutePath();
        File f = new File(path+ ".txt");
        if(f.exists() && !f.isDirectory()) {
            throw new DaoException("file is already exists");
        }
        try (FileWriter fileWriter = new FileWriter(path+ ".txt")){
            fileWriter.write(HEADER);
            fileWriter.write(text.getHeader());
            fileWriter.write("\r\n");
            fileWriter.write(text.getBody());
        } catch (IOException e) {
            System.out.println("Ошибка записи");
            logger.info("File write error");
        }
    }

    @Override
    public String[][] readFromFile(String fileName) throws DaoException {
        String [][] words;
        Path path = Paths.get(fileName).toAbsolutePath();
        try (FileReader fileReader = new FileReader(path + ".txt")) {
            int currentSymbol;
            StringBuilder buffer = new StringBuilder();
            while ((currentSymbol = fileReader.read()) != EOF) {
                buffer.append((char) currentSymbol);
            }
            words = parseWord(buffer.toString());
        } catch (IOException e) {
            System.out.println(e);
            logger.error(e);
            throw new DaoException(fileName + " File not found");
        }
        return words;
    }

    private String[][] parseWord(String string) {
        Pattern patternNewString = Pattern.compile("\\s*([\\r\\n])\\s*");
        Pattern pattern = Pattern.compile("[\\s]");
        String [] stringRows = patternNewString.split(string);
        String [][] words = new String[stringRows.length][];
        int currentRow = 0;
        for (String row : stringRows){
            String [] stringWordsRow = pattern.split(row);
            words[currentRow] = stringWordsRow;
            currentRow++;
        }
        return words;
    }
}
