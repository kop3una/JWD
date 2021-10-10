package by.training.task03.services.creator;

import by.training.task03.beans.Matrix;
import by.training.task03.services.exception.ServicesException;

public interface MatrixCreator {
    Matrix createFromFile(String fileName) throws ServicesException;
}
