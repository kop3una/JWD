package by.training.task03.dao.impl;

import by.training.task03.beans.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileArrayDao implements ArrayDao {
    private final int EOF = -1;
    private final Logger logger = LogManager.getLogger(FileArrayDao.class);

    @Override
    public double[] readArray(String fileName) throws DaoException {
        double[] array = new double[0];
        Path path = Paths.get(fileName).toAbsolutePath();
        try (FileReader fileReader = new FileReader(path + ".txt")) {
            int currentSymbol;
            StringBuilder numbers = new StringBuilder();
            while ((currentSymbol = fileReader.read()) != EOF) {
                numbers.append((char) currentSymbol);
            }
            array = parseNumber(numbers.toString());
        } catch (IOException e) {
            logger.error(e);
            throw new DaoException(fileName + " File not found");
        }

        return array;
    }

    @Override
    public boolean writeArray(Array array, String fileName) {
        Path path = Paths.get(fileName).toAbsolutePath();
        try (FileWriter fileWriter = new FileWriter(path+ "sort.txt")){
            for (int i = 0; i < array.length(); i++){
                fileWriter.write(Double.toString(array.getValue(i)));
                fileWriter.write(" ");
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи");
            logger.info("File write error");
        }
        return true;
    }

    private double[] parseNumber(String string) {
        Pattern pattern = Pattern.compile("[\\s]");
        Pattern findNumber = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        String[] stringNumbers = pattern.split(string);
        List<String> trueNumber = new ArrayList<>();
        for (String number : stringNumbers) {
            Matcher matcher = findNumber.matcher(number);
            boolean found = matcher.matches();
            if (found) {
                trueNumber.add(number);
            }
        }

        double[] numbers = new double[trueNumber.size()];
        for (int i = 0; i < trueNumber.size(); i++) {
            numbers [i] = Double.parseDouble(trueNumber.get(i));
        }

        return numbers;
    }

}
