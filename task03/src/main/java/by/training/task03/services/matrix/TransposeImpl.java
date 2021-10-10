package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public class TransposeImpl implements Transpose {
    public Matrix transpose (Matrix a) throws MatrixExepction {
        int v = a.getHorizontalSize();
        int h = a.getVerticalSize();

        Matrix result = new Matrix(v,h);
        for (int i = 0; i < h; i++){
            for (int j = 0; j < v; j++){
                result.setElement(j,i,a.getElement(i,j));
            }
        }
        return result;
    }
}
