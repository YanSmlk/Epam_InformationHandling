package yan.epam.task2.composite;

import java.util.ArrayList;


public class Leaf implements Component
{
    private char leaf;
    private PartType partType;

    public Leaf(char leaf, PartType partType)
    {
        this.leaf=leaf;
        this.partType=partType;
    }


    @Override
    public void add(Component textPart)
    {
        //
    }

    @Override public void delete(Component textPart)
    {
        //
    }

    @Override
    public ArrayList<Component> getComponents()
    {
        return null;
    }

    @Override
    public PartType getPartType()
    {
        return partType;
    }


    @Override
    public String toString()
    {
        return String.valueOf(leaf);
    }

}
