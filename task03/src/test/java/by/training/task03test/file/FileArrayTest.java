package by.training.task03test.file;

import by.training.task03.beans.Array;
import by.training.task03.beans.exception.ArrayException;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.exception.DaoException;
import by.training.task03.dao.impl.FileArrayDao;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileArrayTest {
    @DataProvider(name = "file_read_data_correct")
    public Object[][] createFileReadCorrect() {
        return
                new Object[][]{
                        {"array", new double[]{2.3, 1, 3, 9, 0, 4, -6, 8, 98, 23}},
                        {"arrayEmpty", new double[]{}},
                };
    }

    @DataProvider(name = "file_read_data_incorrect")
    public Object[][] createFileReadIncorrect() {
        return
                new Object[][]{
                        {"1"},
                        {"argskdfmgop12yiyi"},
                        {""},
                };
    }

    @DataProvider(name = "file_write_data_correct")
    public Object[][] createFileWriteCorrect() {
        return
                new Object[][]{
                        {new double[]{2.3, 1, 3, 9, 0, 4, -6, 8, 98, 23}, "array", true},
                        {new double[]{1}, "array", true},
                };
    }

    @Test(description = "Check_file_read_correct",
            dataProvider = "file_read_data_correct")
    public void testReadFileCorrect(String fileName, double[] expected) throws DaoException {
        ArrayDao arrayDao = new FileArrayDao();
        double [] readArr = arrayDao.readArray(fileName);
        Assert.assertEquals(readArr, expected);
    }

    @Test(description = "Check_file_read_incorrect",
            expectedExceptions = DaoException.class,
            dataProvider = "file_read_data_incorrect")
    public void testReadFileIncorrect(String fileName) throws DaoException {
        ArrayDao arrayDao = new FileArrayDao();
        arrayDao.readArray(fileName);
    }

    @Test(description = "Check_file_write_correct",
            dataProvider = "file_write_data_correct")
    public void testWriteFileCorrect(double [] arr,String fileName, boolean expected) throws DaoException, ArrayException {
        ArrayDao arrayDao = new FileArrayDao();
        boolean result = arrayDao.writeArray(new Array(arr),fileName);
        Assert.assertEquals(result,expected);
    }


}
