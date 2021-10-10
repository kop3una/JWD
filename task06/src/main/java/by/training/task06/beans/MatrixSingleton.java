package by.training.task06.beans;

import java.util.concurrent.locks.ReentrantLock;

public class MatrixSingleton { // TODO спросить про фабрику синглтонов с различным заполнением матриц, так же волотаил
    private static SquareMatrix instance;
    private static ReentrantLock locker = new ReentrantLock();
    private MatrixSingleton() {}
    public static SquareMatrix getInstance() {
        if (instance == null) {
            locker.lock();
            {
                if (instance == null) {
                    instance = new SquareMatrix();
                }
            }
            locker.unlock();
        }
        return instance;
    }

    public static void setInstance (SquareMatrix matrix) {
        locker.lock();
        instance = matrix;
        locker.unlock();
    }
}
