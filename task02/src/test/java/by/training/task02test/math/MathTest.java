package by.training.task02test.math;

import by.training.task02.math.Math;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MathTest {

    @DataProvider(name = "compare_data")
    public Object[][] createDataCompare() {
        return
                new Object[][]{
                        {new double[]{0, 0}, 0},
                        {new double[]{324525.3, 0}, 1},
                        {new double[]{0, 1234.243}, -1},
                        {new double[]{Integer.MAX_VALUE, 2452453}, 1}
                };
    }

    @DataProvider(name = "sum_data")
    public Object[][] createDataSum() {
        return
                new Object[][]{
                        {new double[]{0, 0, 0}, 0},
                        {new double[]{36, 0, 2}, 38},
                        {new double[]{10, 10, -100}, -80},
                        {new double[]{Integer.MAX_VALUE, 0, 0}, Integer.MAX_VALUE}
                };
    }

    @DataProvider(name = "abc_data")
    public Object[][] createDataAbc() {
        return
                new Object[][]{
                        {0, 0},
                        {-1, 1},
                        {23, 23},
                        {-100, 100}
                };
    }

    @DataProvider(name = "DigitsArray_data")
    public Object[][] createDataDigitsArray() {
        return
                new Object[][]{
                        {0, new byte[]{0}},
                        {-12345, new byte[]{1,2,3,4,5}},
                        {324235, new byte[]{3,2,4,2,3,5}},
                        {-100, new byte[]{1,0,0}}
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

    @DataProvider(name = "romanToArabic_data")
    public Object[][] createDataRomanToArabic() {
        return
                new Object[][]{
                        {'I', 1},
                        {'V', 5},
                        {'X', 10},
                        {'L', 50},
                        {'C', 100},
                        {'D', 500},
                        {'M', 1000},
                        {'A', -1},
                        {'Z', -1},
                };
    }

    @Test(description = "Compare_in_the_class_Math",
            dataProvider = "compare_data")
    public void testCompare(double[] data, int expected) {
        int actual = Math.compare(data[0], data[1]);
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Sum_in_the_class_Math",
            dataProvider = "sum_data")
    public void testSum(double[] data, double expected) {
        double actual = Math.sum(data[0], data[1],data[2]);
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Abc_in_the_class_Math",
            dataProvider = "abc_data")
    public void testAbc(double data, double expected) {
        double actual = Math.abc(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "DigitsArray_in_the_class_Math",
            dataProvider = "DigitsArray_data")
    public void testDigitsArray(int data, byte [] expected) {
        byte [] actual = Math.getDigitsArray(data);
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "RomanToArabic_in_the_class_Math",
            dataProvider = "romanToArabic_data")
    public void testRomanToArabic(char data, int expected) {
        int actual = Math.romanToArabic(data);
        Assert.assertEquals(actual, expected);
    }

}