package yan.epam.task2.interpreter;

import java.util.ArrayDeque;


public class Context
{
    private ArrayDeque<Double> values=new ArrayDeque<>();

    public Double popValue()
    {
        return this.values.pop();
    }

    public void pushValue(Double value)
    {
        this.values.push(value);
    }

}
