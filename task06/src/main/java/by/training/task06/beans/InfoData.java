package by.training.task06.beans;

public class InfoData {
    private int matrixSize;
    private int countOfThread;

    public InfoData (int matrixSize, int countOfThread){
       this.matrixSize = matrixSize;
       this.countOfThread = countOfThread;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public void setMatrixSize(int matrixSize) {
        this.matrixSize = matrixSize;
    }

    public int getCountOfThread() {
        return countOfThread;
    }

    public void setCountOfThread(int countOfThread) {
        this.countOfThread = countOfThread;
    }
}
