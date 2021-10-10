package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public class SubtractionImpl implements Subtraction{
    @Override
    public Matrix sub(Matrix a, Matrix b) throws MatrixExepction {
        int v = a.getHorizontalSize();
        int h = a.getVerticalSize();
        if ( !( (v == b.getHorizontalSize()) && (h == b.getVerticalSize()) ) ){
            throw new MatrixExepction("incompatible matrix");
        }
        Matrix result = new Matrix(v,h);
        for (int i = 0; i < v; i++){
            for (int j = 0; j < h; j++ ){
                result.setElement(i,j,a.getElement(i,j)-b.getElement(i,j));
            }
        }
        return result;
    }
}
