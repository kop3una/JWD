package ex01_threadhelloworld;

public class MyThread extends Thread {

    public void run (){
        System.out.println("Hello World!");
    }

    public static void main (String [] args){
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("main");
    }
}
