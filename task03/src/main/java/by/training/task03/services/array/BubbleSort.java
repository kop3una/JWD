package by.training.task03.services.array;

import by.training.task03.beans.Array;

public class BubbleSort implements Sorting {
    @Override
    public void sortIncrease(Array array) {
        int length = array.length();
        for (int i = 1; i < length;i++){
            for (int j = 0; j< length-i; j++){
                if (array.getValue(j)>array.getValue(j+1)){
                    array.swap(j,j+1);
                }
            }
        }
    }

    @Override
    public void sortDecrease(Array array) {
        int length = array.length();
        for (int i = 1; i < length;i++){
            for (int j = 0; j< length-i; j++){
                if (array.getValue(j)<array.getValue(j+1)){
                    array.swap(j,j+1);
                }
            }
        }
    }
}
