package by.training.task01test;

import by.training.task01.service.Task14;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task14Test {
    @DataProvider(name = "positive_input_r")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {0, new double[]{0,0}},
                        {1/Math.PI, new double[]{2,1/Math.PI}},
                        {Math.PI, new double[]{2*Math.PI*Math.PI,Math.pow(Math.PI,3)}},
                };
    }

    @DataProvider(name = "negative_input_r") // to do exeption
    public Object[][] createIncorrectData() {
        return
                new Object[][]{
                        {-1, new double[]{-1,-1}},
                        {-10, new double[]{-1,-1}},
                        {-1242342, new double[]{-1,-1}},
                };
    }

    @Test(description = "Positive scenery of the Task14",
            dataProvider = "positive_input_r")
    public void testPositive(double r, double [] expected) {
        Task14 task14 = new Task14(r);
        double [] actual = new double[]{task14.circumference(), task14.areaCircle()};
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task6",
            dataProvider = "negative_input_r")
    public void testNegative(double r, double [] expected) {
        Task14 task14 = new Task14(r);
        double actual [] = new double[]{task14.circumference(), task14.areaCircle()};
        Assert.assertEquals(actual, expected);
    }
}
