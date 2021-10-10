package by.training.task06.beans;

import by.training.task06.beans.exception.MatrixExepction;

public class Matrix { // TODO MatrixSquare extends Matrix
    protected int[][] a;

    public Matrix (){ this.a = new int[0][0];}

    public Matrix(int[][] a) {
        this.a = a;
    }

    public Matrix(int n, int m) throws MatrixExepction {
        if (n < 1 || m < 1) {// check input
            throw new MatrixExepction("Error of size");
        }
        a = new int[n][m];
    }

//    public Matrix (Matrix matrix) throws MatrixExepction {
//        for (int i = 0; i < matrix.getHorizontalSize(); i++){
//            for (int j = 0; j< matrix.getVerticalSize(); j++){
//                this.a[i][j] = matrix.getElement(i,j);
//            }
//        }
//    }

    public int getVerticalSize() {
        return a.length;
    }

    public int getHorizontalSize() {
        return a[0].length;
    }

    public int getElement(int i, int j) throws MatrixExepction {
        if (checkRange(i, j)) { // check i & j
            return a[i][j];
        } else {
            throw new MatrixExepction("No element");
        }
    }

    public boolean setElement(int i, int j, int value) throws MatrixExepction {
        if (checkRange(i, j)) {
            a[i][j] = value;
            return true;
        } else {
            throw new MatrixExepction("No position to set element");
        }
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x"
                + a[0].length + "\n");
        for (int [ ] row : a) {
            for (int value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }

    protected boolean checkRange(int i, int j) {// check matrix range
        return (i >= 0 && i < a.length && j >= 0 && j < a[0].length);
    }
}
