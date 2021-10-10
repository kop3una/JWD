package by.training.task03.services.array;

import by.training.task03.beans.Array;

public class ShellSort implements Sorting {
    @Override
    public void sortIncrease(Array array) {
        int length = array.length();

        for (int step = length / 2; step > 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                if (array.getValue(j) > array.getValue(j + step)) {
                    array.swap(j, j + step);
                }
            }
        }

        for (int i = 1; i < length; i++){
            double key = array.getValue(i);
            int j = i-1;
            while ( (j >= 0) && (array.getValue(j) > key)){
                array.setValue(array.getValue(j),j+1);
                j--;
            }
            array.setValue(key,j+1);
        }
    }

    @Override
    public void sortDecrease(Array array) {
        int length = array.length();

        for (int step = length / 2; step > 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                if (array.getValue(j) < array.getValue(j + step)) {
                    array.swap(j, j + step);
                }
            }
        }

        for (int i = 1; i < length; i++){
            double key = array.getValue(i);
            int j = i-1;
            while ( (j >= 0) && (array.getValue(j) < key)){
                array.setValue(array.getValue(j),j+1);
                j--;
            }
            array.setValue(key,j+1);
        }
    }
}
