package by.training.task03.services.array;

import by.training.task03.beans.Array;

public class ShakerSort implements Sorting {
    @Override
    public void sortIncrease(Array array) {
        int length = array.length();
        for (int i = 0; i < (length-1)-i;i++){
            for (int j = i; j< (length-1)-i; j++){
                if (array.getValue(j)>array.getValue(j+1)){
                    array.swap(j,j+1);
                }
            }
            for (int j = (length-2) - i; j > i; j--){
                if (array.getValue(j)<array.getValue(j-1)){
                    array.swap(j,j-1);
                }
            }
        }
    }

    @Override
    public void sortDecrease(Array array) {
        int length = array.length();
        for (int i = 0; i < (length-1)-i;i++){
            for (int j = i; j< (length-1)-i; j++){
                if (array.getValue(j)<array.getValue(j+1)){
                    array.swap(j,j+1);
                }
            }
            for (int j = (length-2) - i; j > i; j--){
                if (array.getValue(j)>array.getValue(j-1)){
                    array.swap(j,j-1);
                }
            }
        }
    }
}
