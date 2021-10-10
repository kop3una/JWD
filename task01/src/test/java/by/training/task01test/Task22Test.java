package by.training.task01test;

import by.training.task01.service.Task22;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task22Test {
    @DataProvider(name = "positive_input_time")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {3600, "1ч 0мин 0c"},
                        {3665, "1ч 1мин 5c"},
                        {60, "0ч 1мин 0c"},
                        {0, "0ч 0мин 0c"},
                        {7205, "2ч 0мин 5c"},
                        {365, "0ч 6мин 5c"},
                        {Integer.MAX_VALUE, "596523ч 14мин 7c"}
                };
    }

    @DataProvider(name = "negative_input_time")
    public Object[][] createIncorrectData() {
        return
                new Object[][]{
                        {-1, "Время неотрицательное число"},
                        {-345, "Время неотрицательное число"},
                        {-42357235, "Время неотрицательное число"},
                };
    }

    @Test(description = "Positive scenery of the Task22",
            dataProvider = "positive_input_time")
    public void testPositive(int time, String expected) {
        Task22 task22 = new Task22(time);
        String actual = task22.getTime();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Negative scenery of the Task22",
            dataProvider = "negative_input_time")
    public void testNegative(int time, String expected) {
        Task22 task22 = new Task22(time);
        String actual = task22.getTime();
        Assert.assertEquals(actual, expected);
    }
}
