package by.training.task02.branching;
import by.training.task02.math.Math;

/**
 * This Task is about Redistribute the values of the variables x and y so that the larger of these values appears in x,
 * and the smaller of these values in y.
 */

public class Task22Branching {

    private double x;
    private double y;

    /**
     * @param x x
     * @param y y
     */
    public Task22Branching(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Compares values, swaps them if necessary.
     */
    public void distributeXY (){
        if (Math.compare(x,y) == 1){
            System.out.println("В х изначально находится большее значение");
        } else if (Math.compare(x,y) == -1){
            double c;
            c = x;
            x = y;
            y = c;
            System.out.println("В х: " + x + " в y: " + y);
        } else {
            System.out.println("Числа равны");
        }
    }
}
