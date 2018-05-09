package test.yan.epam.task2.interpreter;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import yan.epam.task2.exception.IncorrectDataException;
import yan.epam.task2.interpreter.ExpressionCalculator;
import static org.testng.Assert.fail;


public class ExpressionCalculatorTest
{
    private ExpressionCalculator expCalc;
    private String lexeme;

    @BeforeClass
    public void setParam()
    {
        expCalc=new ExpressionCalculator();
    }

    @AfterClass
    public void clearParam()
    {
        expCalc=null;
    }

    @Test
    public void simpleExpressionCalcTest()
    {
        try
        {
            final String EXPECTED = "11.0";
            lexeme = "5 3 2 * +";
            expCalc.addOperations(lexeme);
            lexeme = expCalc.calcExpression();
            Assert.assertEquals(EXPECTED,lexeme);
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void ExpressionCalcTest()
    {
        try
        {
            final String EXPECTED = "6.0";
            lexeme = "71 2 4 * 3 2 1 2 / 2 * - 2 * * 10 2 / - - 6";
            expCalc.addOperations(lexeme);
            lexeme = expCalc.calcExpression();
            Assert.assertEquals(EXPECTED,lexeme);
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

}
