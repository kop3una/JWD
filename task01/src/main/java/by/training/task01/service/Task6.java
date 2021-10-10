package by.training.task01.service;

/**
 * Task6 is about size of basket with milk.
 */

public class Task6 {

    private final int countLittleBuckets;

    /**
     * Constructor to calculate the size of large buckets.
     * @param countLittleBuckets count little size buckets.
     */
    public Task6(int countLittleBuckets) {
        this.countLittleBuckets = countLittleBuckets;
    }

    /**
     * @return size of the large buckets.
     */
    public double getSizeLargeBuckets() {
        if (this.countLittleBuckets <= 0){
            return -1;
        } else {
            return 80. / countLittleBuckets + 12;
        }
    }
}
