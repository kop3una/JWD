package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public class MultiplicationImpl implements Multiplication{

    public Matrix multiply (Matrix a, Matrix b) throws MatrixExepction {
        int v = a.getVerticalSize();
        int h = b.getHorizontalSize();
        int controlSize = a.getHorizontalSize();
        if (controlSize != b.getVerticalSize()) {
            throw new MatrixExepction("incompatible matrix");
        }
        Matrix result = new Matrix(v, h);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                int value = 0;
                for (int k = 0; k < controlSize; k++) {
                    value += a.getElement(i, k) * b.getElement(k, j);
                }
                result.setElement(i, j, value);
            }
        }
        return result;
    }

    public Matrix multiply (Matrix a, int b) throws MatrixExepction {
        int v = a.getVerticalSize();
        int h = a.getHorizontalSize();

        Matrix result = new Matrix(v,h);
        for (int i = 0; i < v; i++){
            for (int j =0; j < h; j++){
                result.setElement(i,j,a.getElement(i,j)*b);
            }
        }
        return result;
    }
}
