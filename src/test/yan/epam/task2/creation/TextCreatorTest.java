package test.yan.epam.task2.creation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import yan.epam.task2.creation.TextCreator;
import yan.epam.task2.exception.DataFileException;
import static org.testng.AssertJUnit.fail;

public class TextCreatorTest
{
    private TextCreator textCreator;
    private String text;

    @BeforeClass
    public void setParam()
    {
        textCreator=new TextCreator();
    }

    @AfterClass
    public void clearParam()
    {
        textCreator=null;
    }

    @Test
    public void noFileTest()
    {
        final String EXPECTED="No file found: abc";
        try
        {
            text=textCreator.readText("abc");
            fail("Should have thrown a DataFileException(No file found)");
        }
        catch (DataFileException ex)
        {
            Assert.assertEquals(EXPECTED,ex.getMessage());
        }
    }

    @Test
    public void noFileNameTest()
    {
        final String EXPECTED="Empty file name";
        try
        {
            text=textCreator.readText("");
            fail("Should have thrown a DataFileException(Empty file name)");
        }
        catch (DataFileException ex)
        {
            Assert.assertEquals(EXPECTED,ex.getMessage());
        }
    }

    @Test
    public void infoReadTest()
    {
        final String EXPECTED="Hello, its a text.";
        try
        {
            text = textCreator.readText("test3.txt");
            Assert.assertEquals(EXPECTED,text);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }
}
