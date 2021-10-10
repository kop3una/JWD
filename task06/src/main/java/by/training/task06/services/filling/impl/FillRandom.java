package by.training.task06.services.filling.impl;

import by.training.task06.beans.MatrixSingleton;
import by.training.task06.beans.SquareMatrix;
import by.training.task06.services.filling.Filling;

import java.util.Random;

/**
 * Каждый поток берет рандомный элемент и пытается его заполнить, когда матрица заполнена, то она посылает об этом сигнал и все потоки завершаются.
 * Нестабильный алгоритм! Рандом равновероятен, однако, может выполнятся неограниченное количество времени
 * Each thread takes a random element and tries to fill it, when the matrix is full, then it sends a signal and all threads terminate. Unstable algorithm
 */

public class FillRandom implements Filling {

    @Override
    public boolean fill() {
        Random randomNumber = new Random();
        SquareMatrix matrix = MatrixSingleton.getInstance();
        int i;
        while (!matrix.checkFill()){
            i = randomNumber.nextInt(matrix.getSizeOfMatrix());
            if (matrix.checkZero(i,i)){
                matrix.setElement(i,i, randomNumber.nextInt(matrix.getSizeOfMatrix()) + 1);
            }
        }
        return true;
    }

    @Override
    public boolean fill(int size) {
        return false;
    }
}
