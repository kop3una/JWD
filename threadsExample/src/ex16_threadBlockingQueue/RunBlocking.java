package ex16_threadBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class RunBlocking {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        new Thread() {
            public void run() {
                for (int i = 1; i < 4; i++) {
                    try {
                        if (queue.offer("Java" + i,2, TimeUnit.SECONDS)) {
                            System.out.println("Element " + i + " added");
                        } else {
                            System.out.println("Element " + i + " not added");
                        }

                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(3_000);
                    // извлечение одного
                    System.out.println("Element " + queue.take() + " took");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}