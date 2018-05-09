package yan.epam.task2.interpreter.impl;

import yan.epam.task2.interpreter.BaseOperation;
import yan.epam.task2.interpreter.Context;

public class OperationMultiply implements BaseOperation
{

    @Override
    public void interpret(Context context)
    {
        context.pushValue(context.popValue()*context.popValue());
    }

}
