package by.training.task02.cycles;

/**
 * This task is
 * Write a program for calculating the values of the function F (x) on the segment [a, b] with step h. Result
 * represent in the form of a table, the first column of which is the values of the argument, the second is the corresponding
 * function values: F (x) = sin ^ 2 (x)
 */
public class Task22Cycles {
    private final double leftBorder;
    private final double rightBorder;
    private final double step;

    /**
     * @param leftBorder a (from task description)
     * @param rightBorder b (from task description)
     * @param step h (from task description)
     */
    public Task22Cycles(double leftBorder, double rightBorder, double step) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.step = step;
    }

    /**
     * perform function and write result on console;
     */
    public void performFunc (){
        double currentX = leftBorder;
        if (!(step < 0 || leftBorder > rightBorder)) {
            while (currentX <= rightBorder) {
                System.out.printf("X = %.4f | sin^2(x) = %.4f \n", currentX,Math.sin(currentX));
                currentX += step;
            }
        } else {
            System.out.println("Некорректные данные");
        }
    }
}
