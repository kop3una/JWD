package ex05_threadtointerrupted_pertB;

public class RunnerThreadToInterrupt {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        ThreadToInterrupt myThread = new ThreadToInterrupt();
        Thread t = new Thread(myThread,"MyThread");
        t.start();
        try{
            Thread.sleep(205);
            t.interrupt();
            Thread.sleep(150);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
