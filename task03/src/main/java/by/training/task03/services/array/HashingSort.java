package by.training.task03.services.array;

import by.training.task03.beans.Array;

import java.util.ArrayList;
import java.util.Collections;

public class HashingSort implements Sorting {

    @Override
    public void sortIncrease(Array array) {
        Object [] table = new Object[array.length()];
        makeTable(table,array);
        int k = 0;
        for (int i = 0; i < array.length(); i++){
            ArrayList <Double> currentList = (ArrayList<Double>) table[i];
            for (Double aDouble : currentList) {
                array.setValue(aDouble, k);
                k++;
            }
        }

    }

    @Override
    public void sortDecrease(Array array) {
        Object [] table = new Object[array.length()];
        makeTable(table,array);
        int k = 0;
        for (int i = array.length()-1; i >= 0; i--){
            ArrayList <Double> currentList = (ArrayList<Double>) table[i];
            for (int j = currentList.size()-1; j >= 0 ;j--){
                array.setValue(currentList.get(j),k);
                k++;
            }
        }
    }

    private void fillArrayOfList(Object [] table) {
        for (int i =0; i < table.length; i++){
            table[i] = new ArrayList<Integer>();
        }
    }

    private int hashFunc (int length, double range, double minValue, double value){
        if (range < length){
            return (int) (value - minValue);
        } else {
            int result = (int) Math.floor((value - minValue)/Math.ceil(range/length) );
            if (result != length){
                return result;
            } else {
                return result -1;
            }
        }
    }

    private double calcMinValue (Array array){
        double min = array.getValue(0);
        for (int i = 1; i < array.length();i++){
            if (min > array.getValue(i)){
                min = array.getValue(i);
            }
        }
        return min;
    }

    private double calcMaxValue (Array array){
        double max = array.getValue(0);
        for (int i = 1; i < array.length();i++){
            if (max < array.getValue(i)){
                max = array.getValue(i);
            }
        }
        return max;
    }

    private void makeTable (Object [] table, Array array){
        final double MIN_VALUE = calcMinValue(array);
        final double MAX_VALUE = calcMaxValue(array);
        final double RANGE = Math.abs(MAX_VALUE - MIN_VALUE);
        fillArrayOfList(table);
        for (int i = 0; i < array.length(); i++){
            ArrayList <Double> currentList = (ArrayList<Double>) table[ hashFunc(array.length(),RANGE,MIN_VALUE,array.getValue(i))];
            currentList.add(array.getValue(i));
        }
        for (int i = 0; i < array.length(); i++){
            ArrayList <Double> currentList = (ArrayList<Double>) table[i];
            Collections.sort(currentList);
        }

    }
}
