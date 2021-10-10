package by.training.task06.services.creator;

import by.training.task06.beans.Matrix;
import by.training.task06.services.exception.ServicesException;

public interface MatrixCreator {
    Matrix createFromFile(String fileName) throws ServicesException;
}
