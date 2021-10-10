package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;
import by.training.task03.controller.exception.ControllerException;
import by.training.task03.services.exception.ServicesException;

public interface Sumator {
    Matrix sum (Matrix a, Matrix b) throws MatrixExepction, ServicesException;
}
