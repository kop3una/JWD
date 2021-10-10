package by.training.task01.service;

/**
 * Task38 is about a point within the bounds of the shape.
 */
public class Task38 {
    /**
     * coordinate x.
     */
    private final double x;
    /**
     * coordinate y.
     */
    private final double y;

    /**
     * @param x coordinate x.
     * @param y coordinate y.
     */
    public Task38 (double x , double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return true if point within bounds of A-shape, else return false.
     */
    public boolean isEnterA (){
        return (x >= -4) && (x <= 4) && (y >= 0) && (y <= 4) && (Math.abs(x) + Math.abs(y) <= 4);
    }

    /**
     * @return true if point within bounds of B-shape, else return false.
     */
    public boolean isEnterB (){
        return ( (x >= -2) && (x <= 2) && (y >= 0) && (y <= 4) ) || ( (x >= -4) && (x <= 4) && (y <= 0) && (y >= -3) );
    }

    /**
     * @return true if point within bounds of C-shape, else return false.
     */
    public boolean isEnterC (){
        return (x >= 0) && (x <= 4) && (y>=0) && (y <= Math.sqrt(16 - x * x)) || (x >= 0) && (x <= 5) && (y<=0) && (y >= -Math.sqrt(25 - x * x));
    }

}
