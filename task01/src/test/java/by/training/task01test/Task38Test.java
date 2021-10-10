package by.training.task01test;

import by.training.task01.service.Task38;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task38Test {
    private final int X = 0;
    private final int Y = 1;

    @DataProvider(name = "positive_input_xy_A")
    public Object[][] createCorrectDataA() {
        return
                new Object[][]{
                        {new double[]{0,0}, true },
                        {new double[]{1.3,0}, true},
                        {new double[]{3,1}, true},
                        {new double[]{-2,2}, true},
                        {new double[]{0,2}, true},
                        {new double[]{-2,0}, true},
                        {new double[]{1.1,1.7}, true},
                        {new double[]{-1,2}, true},
                };
    }

    @DataProvider(name = "negative_input_xy_A")
    public Object[][] createIncorrectDataA() {
        return
                new Object[][]{
                        {new double[]{1,4}, false},
                        {new double[]{4,1}, false},
                        {new double[]{10,1}, false},
                        {new double[]{0,-234}, false},
                        {new double[]{Integer.MAX_VALUE,1}, false},
                        {new double[]{-43,-3425}, false},
                };
    }

    @DataProvider(name = "positive_input_xy_B")
    public Object[][] createCorrectDataB() {
        return
                new Object[][]{
                        {new double[]{0,0}, true },
                        {new double[]{1,4}, true},
                        {new double[]{2,4}, true},
                        {new double[]{-1.9,2}, true},
                        {new double[]{0,2}, true},
                        {new double[]{-2.1,0}, true},
                        {new double[]{1,1}, true},
                        {new double[]{-1.3,2}, true},
                        {new double[]{0,-2}, true},
                        {new double[]{2,-1}, true},
                        {new double[]{-3,-3}, true},
                        {new double[]{4,0}, true},
                };
    }

    @DataProvider(name = "negative_input_xy_B")
    public Object[][] createIncorrectDataB() {
        return
                new Object[][]{
                        {new double[]{1,5}, false},
                        {new double[]{4,1}, false},
                        {new double[]{-3,-4}, false},
                        {new double[]{10,1}, false},
                        {new double[]{0,-234}, false},
                        {new double[]{Integer.MAX_VALUE,1}, false},
                        {new double[]{-43,-3425}, false},
                };
    }

    @DataProvider(name = "positive_input_xy_C")
    public Object[][] createCorrectDataC() {
        return
                new Object[][]{
                        {new double[]{0,-1}, true },
                        {new double[]{1,-3}, true},
                        {new double[]{2,-Math.sqrt(25-4)}, true},
                        {new double[]{5,0}, true},
                        {new double[]{2,Math.sqrt(16-4)}, true},
                        {new double[]{3,2.01}, true},
                        {new double[]{2,3}, true},
                        {new double[]{0.4,2}, true},
                        {new double[]{0,0}, true},
                        {new double[]{1,-1.5}, true},
                        {new double[]{3,4}, false},
                };
    }

    @DataProvider(name = "negative_input_xy_C")
    public Object[][] createIncorrectDataC() {
        return
                new Object[][]{
                        {new double[]{1,5}, false},
                        {new double[]{4,1}, false},
                        {new double[]{3,-4.2}, false},
                        {new double[]{10,1}, false},
                        {new double[]{0,-234}, false},
                        {new double[]{Integer.MAX_VALUE,1}, false},
                        {new double[]{-43,-3425}, false},
                };
    }

    @Test(description = "Positive scenery of the Task38",
            dataProvider = "positive_input_xy_A")
    public void testPositiveA(double [] xy , boolean expected) {
        Task38 task38 = new Task38(xy[X],xy[Y]);
        boolean actual = task38.isEnterA();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task38",
            dataProvider = "negative_input_xy_A")
    public void testNegativeA(double [] xy , boolean expected) {
        Task38 task38 = new Task38(xy[X],xy[Y]);
        boolean actual = task38.isEnterA();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Positive scenery of the Task38",
            dataProvider = "positive_input_xy_B")
    public void testPositiveB(double [] xy , boolean expected) {
        Task38 task38 = new Task38(xy[X],xy[Y]);
        boolean actual = task38.isEnterB();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task38",
            dataProvider = "negative_input_xy_B")
    public void testNegativeB(double [] xy , boolean expected) {
        Task38 task38 = new Task38(xy[X],xy[Y]);
        boolean actual = task38.isEnterB();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Positive scenery of the Task38",
            dataProvider = "positive_input_xy_C")
    public void testPositiveC(double [] xy , boolean expected) {
        Task38 task38 = new Task38(xy[X],xy[Y]);
        boolean actual = task38.isEnterC();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task38",
            dataProvider = "negative_input_xy_C")
    public void testNegativeC(double [] xy , boolean expected) {
        Task38 task38 = new Task38(xy[X],xy[Y]);
        boolean actual = task38.isEnterC();
        Assert.assertEquals(actual, expected);
    }
}
