package ex05_threaddemon_partC;

public class ThreadDemon {

    public static void main(String[] args) {
        new WorkerThread().start();

        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            // handle here exception
        }

        System.out.println("Main Thread ending") ;
    }

}

class WorkerThread extends Thread {

    public WorkerThread() {
        // When false, (i.e. when it's a non daemon thread),
        // the WorkerThread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the WorkerThread terminates when the main
        // thread or/and user defined thread(non daemon) terminates.
        setDaemon(true);
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from Worker "+count++);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                // handle exception here
            }
        }
    }
}