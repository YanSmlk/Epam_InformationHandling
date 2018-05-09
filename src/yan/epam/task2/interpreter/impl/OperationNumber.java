package yan.epam.task2.interpreter.impl;

import yan.epam.task2.interpreter.BaseOperation;
import yan.epam.task2.interpreter.Context;

public class OperationNumber implements BaseOperation
{
    private double number;

    public OperationNumber(double number)
    {
        this.number=number;
    }

    @Override
    public void interpret(Context context)
    {
        context.pushValue(number);
    }
}
