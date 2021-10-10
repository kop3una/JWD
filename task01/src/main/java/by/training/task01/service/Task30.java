package by.training.task01.service;

/**
 * Task30 is physical problem of finding the resistance of parallel connected resistors.
 */

public class Task30 {
    /**
     * resistance of first resistor.
     */
    private final double r1;
    /**
     * resistance of second resistor.
     */
    private final double r2;
    /**
     * resistance of third resistor.
     */
    private final double r3;

    /**
     * @param r1 resistance of first resistor.
     * @param r2 resistance of second resistor.
     * @param r3 resistance of third resistor.
     */
    public Task30 (double r1, double r2, double r3){
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    /**
     * @return total resistance.
     */
    public double getResistance (){
        if (r1 <= 0 || r2<=0 || r3<=0){
            return -1;
        } else {
            return (r1*r2*r3)/(r1+r2+r3);
        }
    }
}
