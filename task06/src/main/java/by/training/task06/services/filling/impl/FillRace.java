package by.training.task06.services.filling.impl;

import by.training.task06.beans.MatrixSingleton;
import by.training.task06.beans.SquareMatrix;
import by.training.task06.services.filling.Filling;

import java.util.Random;

/**
 * M threads are created, each one tries to write its value to the n-th element of the matrix in order, if the element is busy, the thread goes to the next
 * Создано M потоков, каждый пытается записать в n-ый элемент матрицы по порядку свое значение, если элемент занят, поток переходит к следующему
 * Для проверки нужно запустить несколько раз, часто однин поток "обгоняет всех"
 */

public class FillRace implements Filling {

    @Override
    public boolean fill() {
        Random randomNumber = new Random();
        SquareMatrix matrix = MatrixSingleton.getInstance();
        for (int i =0; i < matrix.getHorizontalSize(); i++){
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
