package by.training.task06.dao.impl;

import by.training.task06.beans.Matrix;
import by.training.task06.beans.exception.MatrixExepction;
import by.training.task06.dao.MatrixDao;
import by.training.task06.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMatrixDao implements MatrixDao {
    private static final int EOF = -1;
    private final Logger logger = LogManager.getLogger(FileMatrixDao.class);
    @Override
    public int[][] readMatrix(String fileName) throws DaoException {
        int [][] matrix;
        Path path = Paths.get(fileName).toAbsolutePath();
        try (FileReader fileReader = new FileReader(path + ".txt")) {
            int currentSymbol;
            StringBuilder numbers = new StringBuilder();
            while ((currentSymbol = fileReader.read()) != EOF) {
                numbers.append((char) currentSymbol);
            }
            matrix = parseMatrix(numbers.toString());
        } catch (IOException e) {
            logger.error(e);
            throw new DaoException(fileName + " File not found");
        }
        return matrix;
    }

    @Override
    public boolean writeMatrix(Matrix matrix, String dirName) {
        Path path = Paths.get(dirName).toAbsolutePath();
        try (FileWriter fileWriter = new FileWriter(path+ "Matrix complete.txt")){
            for (int i = 0; i < matrix.getVerticalSize(); i++){
                for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                    fileWriter.write(Double.toString(matrix.getElement(i, j)));
                    fileWriter.write(" ");
                }
                fileWriter.write("\r\n");
            }
        } catch (IOException | MatrixExepction e){
            System.out.println("Ошибка записи");
            logger.info("File write error");
        }
        return true;
    }

    private int[][] parseMatrix(String string) {
        Pattern patternNewString = Pattern.compile("\\s*([\\r\\n])\\s*");
        Pattern pattern = Pattern.compile("[\\s]");
        Pattern findNumber = Pattern.compile("[-+]?[0-9]+");
        String [] stringRows = patternNewString.split(string);
        stringRows = Arrays.copyOfRange(stringRows,1,stringRows.length);
        int [][] matrix = new int[stringRows.length][];
        int currentRow = 0;
        for (String row : stringRows){
            String [] stringNumbers = pattern.split(row);
            List <String> trueNumber = new ArrayList<>();
            for (String number : stringNumbers){
                Matcher matcher = findNumber.matcher(number);
                boolean found = matcher.matches();
                if (found){
                    trueNumber.add(number);
                }
            }

            int [] rowMatrix = new int[trueNumber.size()];
            for (int i = 0; i < trueNumber.size(); i++) {
            rowMatrix [i] = Integer.parseInt(trueNumber.get(i));
            }
            matrix[currentRow] = rowMatrix;
            currentRow++;
        }

        return matrix;
    }
}
