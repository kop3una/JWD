package ex03_threadpriority;

public class PriorityRunner {
    public static void main(String[ ] args) {
        PriorityThread min = new PriorityThread("Min");
        PriorityThread max = new PriorityThread("Max");
        PriorityThread norm = new PriorityThread("Norm");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        norm.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        norm.start();
        max.start();
    }
}
