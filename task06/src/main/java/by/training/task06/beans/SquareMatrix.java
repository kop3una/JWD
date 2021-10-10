package by.training.task06.beans;

import java.util.concurrent.locks.ReentrantLock;

public class SquareMatrix extends Matrix {
    private static final ReentrantLock locker = new ReentrantLock();

    public SquareMatrix(){}

    public SquareMatrix(int[][] a) {
        super.a = a;
    }

    @Override
    public boolean setElement(int i, int j, int value){
                locker.lock();
                if (a[i][j] == 0){
                    a[i][j] = value;
                    System.out.println(Thread.currentThread().getName() + " установил элемент " + i + " " + j);
                    locker.unlock();
                    return true;
                } else {
                    locker.unlock();
                    return false;
    //                System.out.println(Thread.currentThread().getName() + "не установил элемент " + i + " " + j);
                }

    }

    public boolean checkZero(int i, int j) {
          //    System.out.println(Thread.currentThread().getName() + " проверяет элемент " + i + " " + j + " на 0 " + (a[i][j] == 0));
                return a[i][j] == 0;
    }

    public int getSizeOfMatrix(){
        return getVerticalSize();
    }

    public boolean checkFill(){
        for (int i = 0; i < a.length; i++){
                if (a[i][i] == 0 ){
                    return false;
                }
        }
        return true;
    }
}
