package by.training.task06.dao.impl;

import by.training.task06.dao.InfoDataDao;
import by.training.task06.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileInfoData implements InfoDataDao {
    private static final int EOL = 10;
    private final Logger logger = LogManager.getLogger(FileMatrixDao.class);

    @Override
    public int[] readData(String fileName) throws DaoException {
        int[] data;
        Path path = Paths.get(fileName).toAbsolutePath();
        try (FileReader fileReader = new FileReader(path + ".txt")) {
            int currentSymbol;
            StringBuilder numbers = new StringBuilder();
            while ((currentSymbol = fileReader.read()) != EOL) {
                numbers.append((char) currentSymbol);
            }
            data = parseInfoData(numbers.toString());
        } catch (IOException e) {
            logger.error(e);
            throw new DaoException(fileName + " File not found");
        }
        return data;
    }

    private int[] parseInfoData(String string) {
        Pattern pattern = Pattern.compile("[\\s]");
        Pattern findNumber = Pattern.compile("[-+]?[0-9]+");
        String[] stringNumbers = pattern.split(string);
        List<String> trueNumber = new ArrayList<>();
        int[] data = new int[stringNumbers.length];
        int currentNumber = 0;
        for (String number : stringNumbers) {
            Matcher matcher = findNumber.matcher(number);
            boolean found = matcher.matches();
            if (found) {
                trueNumber.add(number);
            }
            for (int i = 0; i < trueNumber.size(); i++) {
                data[i] = Integer.parseInt(trueNumber.get(i));
            }
        }
        return data;
    }
}
