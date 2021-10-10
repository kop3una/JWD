package by.training.task03.services.array;

import by.training.task03.beans.Array;

public class SimpleChoiceSort implements Sorting {
    @Override
    public void sortIncrease(Array array) {
        int length = array.length();
        for (int i = 0; i < length-1; i++){
            int min = i;
            for (int j = i+1; j < length;j++){
                if (array.getValue(min) > array.getValue(j)){
                    min = j;
                }
            }
            array.swap(min,i);
        }
    }

    @Override
    public void sortDecrease(Array array) {
        int length = array.length();
        for (int i = 0; i < length-1; i++){
            int max = i;
            for (int j = i+1; j < length;j++){
                if (array.getValue(max) < array.getValue(j)){
                    max = j;
                }
            }
            array.swap(max,i);
        }
    }
}
