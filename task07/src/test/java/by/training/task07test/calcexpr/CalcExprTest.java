package by.training.task07test.calcexpr;

import by.training.task07.services.calcexpr.CalculationExpression;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcExprTest {
    @DataProvider(name = "expr_to_polish")
    public Object[][] createDataForMakePolishStr() {
        return
                new Object[][]{
                        {"(8^5|1&2<<(2|5>>2&71))|1200", "8 5 ^ 1 2 2 5 2 >> 71 & | << & | 1200 | "},
                        {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", "71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 | "},
                        {"~6&9|(3&4)", "6 ~ 9 & 3 4 & | "},
                        {"8^5", "8 5 ^ "}
                };
    }

    @DataProvider(name = "expr_to_int_value")
    public Object[][] createDataForCalcExpr() {
        return
                new Object[][]{
                        {"(8^5|1&2<<(2|5>>2&71))|1200", 1213},
                        {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", 78},
                        {"~6&9|(3&4)", 9},
                        {"8^5", 13}
                };
    }


    @Test(description = "Make_correct_polish_string",
            dataProvider = "expr_to_polish")
    public void testMakePolishString(String expr,String result){
        CalculationExpression calculationExpression = new CalculationExpression();
        Assert.assertEquals(calculationExpression.makePolishString(expr),result);
    }

    @Test(description = "Calculate_correct_expr",
            dataProvider = "expr_to_int_value")
    public void testCalcExpr(String expr,int result){
        CalculationExpression calculationExpression = new CalculationExpression();
        Assert.assertEquals(calculationExpression.calculateExpression(calculationExpression.makePolishString(expr)),result);
    }
}
