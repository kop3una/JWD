package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public interface Transpose {
    Matrix transpose (Matrix a) throws MatrixExepction;
}
