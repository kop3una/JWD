package by.training.task06.services.filling.impl;

import by.training.task06.beans.MatrixSingleton;
import by.training.task06.beans.SquareMatrix;
import by.training.task06.services.filling.Filling;

import java.util.Random;

/**
 *  Multiple filling with streams, i.e. if the 3rd stream has filled the 3rd element, and element 6 is still unfilled (the 6th stream did not have time to start work), then the 3rd stream fills the 6th element
 *  Кратное заполнение потоками, т.е если 3ий поток заполнил 3ий элемент, а элемент 6 еще незаполнен (6 поток не успел начать работу), то 3ий поток заполняет 6ой элемент
 *  Прим: 1ый поток старается заполнить все по порядку
 */

public class FillMod implements Filling {
    @Override
    public boolean fill() {
        String name = Thread.currentThread().getName();
        int id = getMyId(name);
        Random randomNumber = new Random();
        SquareMatrix matrix = MatrixSingleton.getInstance();
        for (int i = 0; i < matrix.getHorizontalSize(); i += id){
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

    private int getMyId (String name){
        int index = name.indexOf(":") + 2;
        return Integer.parseInt(name.substring(index));
    }
}
