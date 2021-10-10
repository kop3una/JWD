package by.training.task04test.file;

import by.training.task04.beans.Word;
import by.training.task04.dao.DaoFactory;
import by.training.task04.dao.TextDao;
import by.training.task04.dao.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileTextTest {
    @DataProvider(name = "file_read_data_correct") // TODO filetest in test
    public Object[][] createFileReadCorrect() {
        return
                new Object[][]{
                        {"helloWorldTest", new String[][]{ { "hello","world"}}   },
                        {"empty", new String[][]{{""}} },
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
    public void testReadFileCorrect(String fileName, String[][] expected) throws DaoException {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        String[][] result = textDao.readFromFile(fileName);
        Assert.assertEquals(result[0], expected[0]);
    }

    @Test(description = "Check_file_read_incorrect",
            expectedExceptions = DaoException.class,
            dataProvider = "file_read_data_incorrect")
    public void testReadFileIncorrect(String fileName) throws DaoException {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        textDao.readFromFile(fileName);
    }
//
//    @Test(description = "Check_file_write_correct",
//            dataProvider = "file_write_data_correct")
//    public void testWriteFileCorrect(double [] arr,String fileName, boolean expected) throws DaoException, ArrayException {
//        ArrayDao arrayDao = new FileArrayDao();
//        boolean result = arrayDao.writeArray(new Array(arr),fileName);
//        Assert.assertEquals(result,expected);
//    }
}
