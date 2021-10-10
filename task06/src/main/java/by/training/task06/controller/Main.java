package by.training.task06.controller;

import by.training.task06.beans.*;
import by.training.task06.beans.exception.MatrixExepction;
import by.training.task06.services.creator.CreatorFactory;
import by.training.task06.services.creator.InfoDataCreator;
import by.training.task06.services.creator.MatrixCreator;
import by.training.task06.services.creator.SquareMatrixCreator;
import by.training.task06.services.exception.ServicesException;
import by.training.task06.services.filling.FillFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String [] args) throws ServicesException, InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        InfoDataCreator infoDataCreator = CreatorFactory.getInstance().getInfoDataCreator();
        InfoData infoData = infoDataCreator.createFromFile("matrix");
        SquareMatrixCreator squareMatrixCreator = CreatorFactory.getInstance().getSquareMatrixCreator();
        SquareMatrix matrix = squareMatrixCreator.createFromFile("matrix");
        MatrixSingleton.setInstance(matrix);

        for (int i = 0; i < infoData.getCountOfThread(); i++){
            MyRunnableThread myRunnableThread = new MyRunnableThread(i);
            myRunnableThread.setFilling(FillFactory.getInstance().getFillMod());
            Thread thread = new Thread(myRunnableThread,"Поток: "+ (i+1));
            threadList.add(thread);
        }

        for (Thread thread : threadList){
            thread.start();
        }

        for (Thread thread : threadList){
            thread.join();
        }
        System.out.println(matrix);

    }
}
