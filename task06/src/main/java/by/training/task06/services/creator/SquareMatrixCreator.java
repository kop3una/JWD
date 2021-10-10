package by.training.task06.services.creator;

import by.training.task06.beans.SquareMatrix;
import by.training.task06.services.exception.ServicesException;

public interface SquareMatrixCreator {
    SquareMatrix createFromFile(String fileName) throws ServicesException;
}
