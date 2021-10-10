package by.training.task03test.sorting;

import by.training.task03.beans.Array;
import by.training.task03.beans.exception.ArrayException;
import by.training.task03.services.array.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortingTest {
    @DataProvider(name = "sorting_increase_data_correct")
    public Object[][] createDataSortingIncrease() {
        return
                new Object[][]{
                        {new double[]{-6.0, 0.0, 1.0, 2.3, 3.0, 4.0, 8.0, 9.0, 23.0}, new double[]{-6.0, 0.0, 1.0, 2.3, 3.0, 4.0, 8.0, 9.0, 23.0}},
                        {new double[]{98.0, 23.0, 9.0, 8.0, 4.0, 3.0, 2.3, 1.0, 0.0, -6.0}, new double[]{-6.0, 0.0, 1.0, 2.3, 3.0, 4.0, 8.0, 9.0, 23.0, 98.0}},
                        {new double[]{2.3, 1, 3, 9, 0, 4, -6, 8, 98, 23}, new double[]{-6.0, 0.0, 1.0, 2.3, 3.0, 4.0, 8.0, 9.0, 23.0, 98.0}},
                        {new double[]{1,1,1,1,1,1}, new double[]{1,1,1,1,1,1}},
                        {new double[]{1}, new double[]{1}},
                      //  {new double[]{Double.MAX_VALUE,Double.MIN_VALUE, 0 }, new double[]{Double.MIN_VALUE, 0, Double.MAX_VALUE}},
                };
    }

    @DataProvider(name = "sorting_decrease_data_correct")
    public Object[][] createDataSortingDecrease() {
        return
                new Object[][]{
                        {new double[]{-6.0, 0.0, 1.0, 2.3, 3.0, 4.0, 8.0, 9.0, 23.0}, new double[]{23.0, 9.0, 8.0, 4.0, 3.0, 2.3, 1.0, 0.0, -6.0}},
                        {new double[]{98.0, 23.0, 9.0, 8.0, 4.0, 3.0, 2.3, 1.0, 0.0, -6.0}, new double[]{98.0, 23.0, 9.0, 8.0, 4.0, 3.0, 2.3, 1.0, 0.0, -6.0}},
                        {new double[]{2.3, 1, 3, 9, 0, 4, -6, 8, 98, 23}, new double[]{98.0, 23.0, 9.0, 8.0, 4.0, 3.0, 2.3, 1.0, 0.0, -6.0}},
                        {new double[]{1,1,1,1,1,1}, new double[]{1,1,1,1,1,1}},
                        {new double[]{1}, new double[]{1}},
                        //  {new double[]{Double.MAX_VALUE,Double.MIN_VALUE, 0 }, new double[]{Double.MAX_VALUE, 0, Double.MIN_VALUE}},
                };
    }

    @DataProvider(name = "sorting_data_incorrect")
    public Object[][] createDataSortingIncorrect() {
        return
                new Object[][]{
                        {new double[]{}},
                        //  {new double[]{Double.MAX_VALUE,Double.MIN_VALUE, 0 }, new double[]{Double.MAX_VALUE, 0, Double.MIN_VALUE}},
                };
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testBubbleSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting bubbleSort = new BubbleSort();
        bubbleSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testHashingSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting hashingSort = new HashingSort();
        hashingSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testInsertionSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting insertionSort = new InsertionSort();
        insertionSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testMergeSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting mergeSort = new MergeSort();
        mergeSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testShakerSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting shakerSort = new ShakerSort();
        shakerSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testShellSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting shellSort = new ShellSort();
        shellSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_increase",
            dataProvider = "sorting_increase_data_correct")
    public void testSimpleChoiceSortingIncrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting simpleChoiceSort = new ShellSort();
        simpleChoiceSort.sortIncrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testBubbleSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting bubbleSort = new BubbleSort();
        bubbleSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testHashingSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting hashingSort = new HashingSort();
        hashingSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testInsertionSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting insertionSort = new InsertionSort();
        insertionSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testMergeSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting mergeSort = new MergeSort();
        mergeSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testShakerSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting shakerSort = new ShakerSort();
        shakerSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testShellSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting shellSort = new ShellSort();
        shellSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            dataProvider = "sorting_decrease_data_correct")
    public void testSimpleChoiceSortingDecrease(double[] inData, double[] expected) throws ArrayException {
        Array array = new Array(inData);
        Sorting simpleChoiceSort = new ShellSort();
        simpleChoiceSort.sortDecrease(array);
        Assert.assertEquals(array.getValues(), expected);
    }

    @Test(description = "Check_sorting_decrease",
            expectedExceptions = ArrayException.class,
            dataProvider = "sorting_data_incorrect")
    public void testSortingIncorrect(double[] inData) throws ArrayException {
        Array array = new Array(inData);
        Sorting simpleChoiceSort = new ShellSort();
        simpleChoiceSort.sortDecrease(array);
    }

}
