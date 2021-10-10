package by.training.task01test;

import by.training.task01.service.Task30;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task30Test {
    private final int R1 = 0;
    private final int R2 = 1;
    private final int R3 = 2;


    @DataProvider(name = "positive_input_resistance")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {new double[]{1,1,1}, 1./3.},
                        {new double[]{3,3,3}, 3},
                        {new double[]{100,10,1}, 100.*10./(111.)},
                        {new double[]{134,154,874}, 134.*154.*874./(134.+154.+874.)},
                };
    }

    @DataProvider(name = "negative_input_resistance")
    public Object[][] createIncorrectData() {
        return
                new Object[][]{
                        {new double[]{1,1,0}, -1},
                        {new double[]{1,1,0}, -1},
                        {new double[]{0,1,1}, -1},
                        {new double[]{-1,3,243}, -1},
                        {new double[]{-23,-23,34}, -1},
                };
    }

    @Test(description = "Positive scenery of the Task30",
            dataProvider = "positive_input_resistance")
    public void testPositive(double [] resistance , double expected) {
        Task30 task30 = new Task30(resistance[R1],resistance[R2],resistance[R3]);
        double actual = task30.getResistance();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task30",
            dataProvider = "negative_input_resistance")
    public void testNegative(double [] resistance , double expected) {
        Task30 task30 = new Task30(resistance[R1],resistance[R2],resistance[R3]);
        double actual = task30.getResistance();
        Assert.assertEquals(actual, expected);
    }
}
