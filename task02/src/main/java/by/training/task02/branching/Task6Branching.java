package by.training.task02.branching;
import by.training.task02.math.Math;

/**
 * Task6 is compare two numbers. This is class show result of compare.
 * @see Math;
 */
public class Task6Branching {

    /**
     * Compare two number and show result;
     * @param a first number
     * @param b second number
     */
    public void compareTwoNumbers (double a, double b){
        if (Math.compare(a,b) == 1){
            System.out.println("A больше, чем B");
        } else if (Math.compare(a,b) == -1){
            System.out.println("B больше, чем A");
        } else {
            System.out.println("Числа равны");
        }
    }
}
