package by.training.task02test.figure;

import by.training.task02.figure.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest { // TODO positive and negative test
    @DataProvider(name = "triangle_data")
    public Object[][] createDataTriangle() {
        return
                new Object[][]{
                        {new double[]{-90, 10}, false},
                        {new double[]{20, 30}, true},
                        {new double[]{89.9, 90}, true},
                        {new double[]{0, 1}, false},
                        {new double[]{90, 30}, true},
                        {new double[]{0, 0}, false},
                        {new double[]{90, 90}, false}
                };
    }

    @DataProvider(name = "right_triangle_data")
    public Object[][] createDataRightTriangle() {
        return
                new Object[][]{
                        {new double[]{-90, 10}, false},
                        {new double[]{20, 30}, false},
                        {new double[]{89.9, 90}, true},
                        {new double[]{0, 1}, false},
                        {new double[]{90, 30}, true},
                        {new double[]{60, 30}, true},
                        {new double[]{45, 45}, true},
                };
    }

    @Test(description = "Check_triangle_in_the_class_Triangle",
            dataProvider = "triangle_data")
    public void testTriangle(double[] data, boolean expected) {
        Triangle triangle = new Triangle(data[0],data[1]);
        boolean actual = triangle.isTriangle();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Check_right_triangle_in_the_class_Triangle",
            dataProvider = "right_triangle_data")
    public void testRightTriangle(double[] data, boolean expected) {
        Triangle triangle = new Triangle(data[0],data[1]);
        boolean actual = triangle.isRightTriangle();
        Assert.assertEquals(actual, expected);
    }
}
