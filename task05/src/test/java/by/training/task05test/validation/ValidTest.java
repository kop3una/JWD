package by.training.task05test.validation;

import by.training.task05.beans.Dot;
import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.exception.ServicesException;
import by.training.task05.services.reader.DataReader;
import by.training.task05.services.reader.ReaderFactory;
import by.training.task05.services.validation.FigureValidator;
import by.training.task05.services.validation.LineValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidTest {
    private static final String REG_EXP_TWO_DOTS = ":";
    private static final String REG_EXP_SPACE = "\\s+";
    private static final String REG_EXP_SEMICOLON = ";";
    private static final int COUNT_DOTS = 4;
    private static final int COUNT_COORDINATES = 3;
    DataReader dataReader = ReaderFactory.getInstance().getDataReaderTest();
    List<String> listFigures = dataReader.readFromFile("validTest");


    public ValidTest() throws ServicesException {
    }


    private String[] getNameAndDots(String figure) {
        return Pattern.compile(REG_EXP_TWO_DOTS).split(figure);
    }

    private List<Dot> getDots(String dots) {
        double[][] dotsArr = new double[COUNT_DOTS][];
        double[] coordinateArr = new double[COUNT_COORDINATES];
        List<Dot> dotList = new ArrayList<>();

        String[] dotsStrArr = Pattern.compile(REG_EXP_SPACE).split(dots.trim());
        int numberOfDot = 0;
        for (String dot : dotsStrArr) {
            String[] digits = Pattern.compile(REG_EXP_SEMICOLON).split(dot);
            for (int i = 0; i < digits.length; i++) {
                coordinateArr[i] = Double.parseDouble(digits[i]);
            }
            dotsArr[numberOfDot] = Arrays.copyOf(coordinateArr,coordinateArr.length);
            numberOfDot++;
        }
        for (double[] dot : dotsArr) {
            Dot newDot = new Dot();
            newDot.setX(dot[0]);
            newDot.setY(dot[1]);
            newDot.setZ(dot[2]);
            dotList.add(newDot);
        }

        return dotList;
    }

    @DataProvider(name = "string_validation")
    public Object[][] createStringValidation() {
        return
                new Object[][]{
                        {"Тетраэдр: 2.0;-1.0;1; 5.0;5;4;   3;2.0;-1; 3;2.0;-1;", true},
                        {":2.0;-1.0;1; 5.0;5;4; 3;2.0;-1; 4.0;1;3;", true},
                        {"Тетраэдр: 2.0;-1.0;1; 5.0:5z:4; 3;2.0;-1; 3;2.0;-1;", false},
                        {"Тетраэдр: 2.0;-1.0;1; 5.0;5z;4; 3;2.0;-1; 3;2.0;-1;", false},
                        {"Тетраэдр: 2.0;-1.0;1; 5.0;5;4; 3;2.0;-1;", false},
                        {"Тетраэдр: 2.0;-1.0;1; 5.0;5;4; 3;2.0;-1; 4.0;1;3;", true}
                };
    }

    @DataProvider(name = "figure_validation")
    public Object[][] createFigureValidation() {
        return
                new Object[][]{
                        {Boolean.FALSE},
                        {Boolean.TRUE},
                        {Boolean.TRUE}
                };
    }


    @Test(description = "LineValidator",
            dataProvider = "string_validation")
    public void testLineValidator(String string,boolean result){
        boolean expr = LineValidator.isValid(string);
        Assert.assertEquals(expr,result);
    }

    @Test(description = "FigureValidator",
            dataProvider = "figure_validation")
    public void testFigureValidator(boolean result) throws ServicesException {
           String[] nameAndDot = getNameAndDots(listFigures.get(0));
            listFigures.remove(0);
            List<Dot> dots = getDots(nameAndDot[1]);
            Tetrahedron tetrahedron = new Tetrahedron();
            tetrahedron.setName(nameAndDot[0]);
            tetrahedron.setFirstDot(dots.get(0));
            tetrahedron.setSecondDot(dots.get(1));
            tetrahedron.setThirdDot(dots.get(2));
            tetrahedron.setFourthDot(dots.get(3));
            Assert.assertEquals(FigureValidator.isValid(tetrahedron), result);
    }
}
