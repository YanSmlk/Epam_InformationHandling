package yan.epam.task2.interpreter;

import org.apache.logging.log4j.Level;
import yan.epam.task2.exception.IncorrectDataException;
import yan.epam.task2.interpreter.impl.*;
import java.util.ArrayList;
import java.util.Scanner;
import static yan.epam.task2.creation.TextCreator.LOGGER;

public class ExpressionCalculator
{
    private ArrayList<BaseOperation> operations=new ArrayList<>();

    public void addOperations(String ppnStr) throws IncorrectDataException
    {
        String[] arr = ppnStr.split("\\s");

        for(String temp:arr)
        {
            switch (temp)
            {
                case "+":
                    operations.add(new OperationPlus());
                    break;
                case "-":
                    operations.add(new OperationMinus());
                    break;
                case "*":
                    operations.add(new OperationMultiply());
                    break;
                case "/":
                    operations.add(new OperationDivide());
                    break;
                default:
                    Scanner sc=new Scanner(temp);
                    if (sc.hasNextInt())
                    {
                        operations.add(new OperationNumber(Double.parseDouble(temp)));
                    }
                    else
                    {
                        throw new IncorrectDataException("Incorrect symbol find");
                    }
            }
        }
    }

    public String calcExpression()
    {
        Context context=new Context();
        for (BaseOperation operation:operations)
        {
            operation.interpret(context);
        }
        String res=String.valueOf(context.popValue());
        LOGGER.log(Level.INFO,"Expression calculated: "+res);
        return res;
    }

}
