package by.training.task01.service;

/**
 * Task14 is about circumference and areaCircle.
 */

public class Task14 {
    /**
     * This fields is the radius of circle.
     */
    private final double r;

    /**
     * @param r radius of circle
     */
    public Task14 (double r){
        this.r = r;
    }

    /**
     * @return circumference.
     */
    public double circumference (){
        if (r < 0){
            return -1;
        } else {
            return 2 * Math.PI * r;
        }
    }

    /**
     * @return circumference.
     */
    public double areaCircle (){
        if (r < 0){
            return -1;
        } else {
            return Math.PI * r * r;
        }
    }
}
