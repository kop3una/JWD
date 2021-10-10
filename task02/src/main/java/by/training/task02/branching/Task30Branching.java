package by.training.task02.branching;
import by.training.task02.math.Math;

/**
 * This task is Real numbers a, b, c are given.
 * Double these numbers if a> b> c and replace them with absolute values if they are not
 */

public class Task30Branching {
    private double a;
    private double b;
    private double c;

    /**
     * @param a a
     * @param b b
     * @param c c
     */
    public Task30Branching(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Perform task.
     */
    public void performTask30 (){
        if ( (Math.compare(a,b) == -1) && (Math.compare(b,c) == -1) ){
            System.out.println("a>b>c - условие верно");
            a *=2;
            b *=2;
            c *=2;
        } else {
            System.out.println("Условие задачи не выполняется");
            a = Math.abc(a);
            b = Math.abc(b);
            c = Math.abc(c);
        }
        System.out.println("В результате a = " + a + " b = "+ b + " c = " + c);
    }

}
