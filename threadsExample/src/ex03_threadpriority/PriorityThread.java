package ex03_threadpriority;

public class PriorityThread extends Thread{
    public PriorityThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i < 1050; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(0); // попробовать sleep(1),sleep(0),sleep(10)
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }

}
