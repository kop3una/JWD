package by.training.task02.figure;
import by.training.task02.math.Math;

/**
 * This class describe Triangle and help execute some task with it.
 */
public class Triangle {
    private final double firstAngle;
    private final double secondAngle;
    private final double thirdAngle;

    /**
     * @param firstAngle
     * @param secondAngle
     */
    public Triangle (double firstAngle, double secondAngle){
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
        this.thirdAngle = 180 - (firstAngle + secondAngle);
    }

    /**
     * Determines if an object is a triangle
     * @return true - is Triangle, false - not a Triangle
     */
    public boolean isTriangle (){
        return (firstAngle > 0 && secondAngle > 0 && thirdAngle > 0) && (Math.sum(firstAngle, secondAngle, thirdAngle) == 180);
    }

    /**
     * Determines if an object is right triangle
     * @return true - is right  Triangle, false - not right Triangle
     */
    public boolean isRightTriangle (){
        return ( (isTriangle()) && (firstAngle == 90) || (secondAngle == 90) || (thirdAngle == 90) );
    }
}
