package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public interface Power {
    Matrix pow (Matrix a, int power) throws MatrixExepction;
}
