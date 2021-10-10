package by.training.task05.services.creator.impl;

import by.training.task05.beans.Dot;
import by.training.task05.beans.FiguresRepository;
import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.creator.TetrahedronCreator;
import by.training.task05.services.exception.ServicesException;
import by.training.task05.services.reader.DataReader;
import by.training.task05.services.reader.ReaderFactory;
import by.training.task05.services.validation.FigureValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TetrahedronCreatorImpl implements TetrahedronCreator {
    private final Logger logger = LogManager.getLogger(TetrahedronCreatorImpl.class);
    private static final String REG_EXP_TWO_DOTS = ":";
    private static final String REG_EXP_SPACE = "\\s+";
    private static final String REG_EXP_SEMICOLON = ";";
    private static final int COUNT_DOTS = 4;
    private static final int COUNT_COORDINATES = 3;

    @Override
    public FiguresRepository createFromFile(String fileName) throws ServicesException {
        DataReader dataReader = ReaderFactory.getInstance().getDataReader();
        FiguresRepository figuresRepository = new FiguresRepository();
        try {
            List<String> figures = dataReader.readFromFile(fileName);
            for (String figure : figures) {
                String[] nameAndDot = getNameAndDots(figure);
                List<Dot> dots = getDots(nameAndDot[1]);
                Tetrahedron tetrahedron = new Tetrahedron();
                tetrahedron.setName(nameAndDot[0]);
                tetrahedron.setFirstDot(dots.get(0));
                tetrahedron.setSecondDot(dots.get(1));
                tetrahedron.setThirdDot(dots.get(2));
                tetrahedron.setFourthDot(dots.get(3));
                if (FigureValidator.isValid(tetrahedron)){
                    figuresRepository.add(tetrahedron);
                }
            }
        } catch (ServicesException e) {
            logger.error(e);
            throw new ServicesException(e);
        }
        return figuresRepository;
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

}
