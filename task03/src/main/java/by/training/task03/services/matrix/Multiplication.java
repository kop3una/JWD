package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public interface Multiplication {

    Matrix multiply (Matrix a, Matrix b) throws MatrixExepction;

    Matrix multiply (Matrix a, int b) throws MatrixExepction;
}
