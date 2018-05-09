package yan.epam.task2.composite;

import java.util.ArrayList;

public interface Component
{
    String toString();
    PartType getPartType();
    void add(Component textPart);
    void delete(Component textPart);
    ArrayList<Component> getComponents();
}
