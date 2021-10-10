package by.training.task03.beans;

import by.training.task03.beans.exception.ArrayException;
import by.training.task03.beans.exception.MatrixExepction;

import java.util.Arrays;

public class Array implements Entity{
    private double[] values;

    public Array (double [] values) throws ArrayException {
        if (values.length > 0){
            this.values = values;
        } else {
            throw new ArrayException("Empty Array");
        }

    }

    public Array(int n) throws ArrayException {
        if (n < 1) {// check input
            throw new ArrayException("Empty Array");
        }
        this.values = new double[n];
    }

    public double getValue(int index)  {
        return values[index];
    }

    public void setValue(double value, int index) {
        values[index] = value;
    }

    public int length (){
        return this.values.length;
    }

    public void swap (int indexA, int indexB){
        double c = values[indexA];
        values[indexA] = values[indexB];
        values[indexB]= c;
    }

    public double [] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Array{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
    private boolean checkRange(int i) {// check matrix range
        return (i >= 0 && i < values.length);
    }
}
