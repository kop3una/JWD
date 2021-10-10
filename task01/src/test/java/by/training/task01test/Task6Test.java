package by.training.task01test;

import by.training.task01.service.Task6;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task6Test {

    @DataProvider(name = "positive_input_n")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {8, 22},
                        {10, 20},
                        {1, 92},
                        {100,12.8}
                };
    }

    @DataProvider(name = "negative_input_n")
    public Object[][] createIncorrectData() {
        return
                new Object[][]{
                        {-1, -1},
                        {0, -1},
                        {-1242342, -1},
                };
    }

    @Test(description = "Positive scenery of the Task6",
            dataProvider = "positive_input_n")
    public void testPositive(int n, double expected) {
        Task6 task6 = new Task6(n);
        double actual = task6.getSizeLargeBuckets();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task6",
            dataProvider = "negative_input_n")
    public void testNegative(int n, double expected) {
        Task6 task6 = new Task6(n);
        double actual = task6.getSizeLargeBuckets();
        Assert.assertEquals(actual, expected);
    }
}
