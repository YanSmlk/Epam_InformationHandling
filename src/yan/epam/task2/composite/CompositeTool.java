package yan.epam.task2.composite;

import java.util.ArrayList;

public class CompositeTool implements Component
{
    private ArrayList<Component> parts;
    private PartType partType;

    public CompositeTool(PartType partType)
    {
        parts=new ArrayList<>();
        this.partType=partType;
    }

    @Override
    public void add(Component textPart)
    {
        parts.add(textPart);
    }

    @Override
    public void delete(Component textPart)
    {
        parts.remove(textPart);
    }

    @Override
    public PartType getPartType()
    {
        return partType;
    }

    @Override
    public ArrayList<Component> getComponents()
    {
        return parts;
    }

    @Override
    public String toString()
    {
        StringBuilder strBld = new StringBuilder();
        for (Component component :parts)
        {
            if (component.getPartType() == PartType.PARAGRAPH)
            {
                strBld.append("\n"+"   ");
            }
            if (component.getPartType() == PartType.LEXEME)
            {
                strBld.append(" ");
            }
            strBld.append(component.toString());
        }
        return strBld.toString();
    }

}
