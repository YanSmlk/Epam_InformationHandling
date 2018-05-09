package yan.epam.task2.interpreter.impl;

import yan.epam.task2.interpreter.BaseOperation;
import yan.epam.task2.interpreter.Context;


public class OperationDivide implements BaseOperation
{
    @Override
    public void interpret(Context context)
    {
        Double second = context.popValue();
        Double first = context.popValue();
        context.pushValue(first / second);
    }

}
