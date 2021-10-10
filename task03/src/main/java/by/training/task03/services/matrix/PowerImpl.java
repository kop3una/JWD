package by.training.task03.services.matrix;

import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;

public class PowerImpl implements Power {

    public Matrix pow (Matrix a, int power) throws MatrixExepction {
        Multiplication multiplicationImpl = new MultiplicationImpl();
        int v = a.getHorizontalSize();
        int h = a.getVerticalSize();
        if (power < 0) {
            throw new MatrixExepction("power must be > 0");
        }
        Matrix result = new Matrix(v,h);

        for (int i=0; i<v; i++){
            for (int j = 0; j < h;j++){
                result.setElement(i,j,a.getElement(i,j));
            }
        }

        for (int i = 1; i < power; i++){
            result = multiplicationImpl.multiply(result,a);
        }

        return result;
    }
}
