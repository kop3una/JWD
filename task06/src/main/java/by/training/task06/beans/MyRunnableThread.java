package by.training.task06.beans;

import by.training.task06.services.filling.Filling;

public class MyRunnableThread implements Runnable{
    private int id;
    private Filling filling;
    int size; // для вызова с size если делать UI

    public MyRunnableThread(int id){
        this.id = id;
    }
    public MyRunnableThread(int id, int size){
        this.id = id;
        this.size = size;
    }

    @Override
    public void run() {
        System.out.println("Поток: "+id+" запущен");
        if (!filling.fill()){
            filling.fill(3); // для size
            //filling.fill(size); //
        }
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }
}
