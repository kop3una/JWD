package by.training.task02.branching;

/**
 * This task is about perform function. Function is define in two intervals.
 */
public class Task38Branching {
    private final double x;

    public Task38Branching(double x){
        this.x = x;
    }

    /**
     * @return value of function
     */
    public double performFunc(){
        if ( (x>=0) && (x<=3)){
            return x*x;
        } else {
            return 4;
        }
    }
}
