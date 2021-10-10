package by.training.task06.services.filling.impl;

import by.training.task06.beans.MatrixSingleton;
import by.training.task06.beans.SquareMatrix;
import by.training.task06.services.filling.Filling;

import java.util.Random;

/**
 * Рассчитывается среднее значение элементов, которое должен заполнить один поток. Начальный элемент рандомный Он в порядке гонок
 * @see FillRace  заполняет необходимое количество и останавливается.
 * Для программы установил в параметре size = 3
 * @see by.training.task06.beans.MyRunnableThread
 * смотреть на очередность устновленных элементов, они иногда в разброс!
 * The average value of the elements is calculated, which must be filled by one stream. He, in the order of the races
 * @see FillRace, fills in the required amount and stops.
 */


public class FillSize implements Filling {

    @Override
    public boolean fill() {
       return false;
    }

    /**
     * size - количество потоков
     * size < matrix.getSizeOfMatrix
     */
    @Override
    public boolean fill(int size) {
        Random randomNumber = new Random();
        SquareMatrix matrix = MatrixSingleton.getInstance();
        if (size < matrix.getSizeOfMatrix()){
            int countOfFill = matrix.getSizeOfMatrix()/size;
            int currentFill = 0;
            int i = randomNumber.nextInt(matrix.getSizeOfMatrix());
            while (!matrix.checkFill() && countOfFill != currentFill){
                if (matrix.checkZero(i,i)){
                    if (matrix.setElement(i,i, randomNumber.nextInt(matrix.getSizeOfMatrix()) + 1)){
                        currentFill++;
                    }
                }
                i++;
                if (i > matrix.getSizeOfMatrix() - 1){
                    i = 0;
                }
            }
            return true;
        } else {
            return false;
        }

    }

}
