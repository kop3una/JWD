package ex05_threadtointerrupted_pertB;

public class ThreadToInterrupt implements Runnable{
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){
                System.out.println(Thread.currentThread().getName() + " has been interrupted");
                System.out.println(Thread.currentThread().isInterrupted());    // false
                Thread.currentThread().interrupt();    // повторно сбрасываем состояние
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
