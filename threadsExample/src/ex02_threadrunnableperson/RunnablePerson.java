package ex02_threadrunnableperson;

public class RunnablePerson extends Person implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(getName() + ": Hello World!!!!!");
        }
    }

    public RunnablePerson (String name){
        super(name);
    }

    public static void main (String [] args){
        RunnablePerson p1 = new RunnablePerson("ALice");
        Thread t1 = new Thread(p1);
        t1.start();
        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread t2 = new Thread(p2);
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
