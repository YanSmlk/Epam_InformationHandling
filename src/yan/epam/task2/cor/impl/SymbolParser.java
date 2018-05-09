package yan.epam.task2.cor.impl;

import yan.epam.task2.composite.Component;
import yan.epam.task2.composite.Leaf;
import yan.epam.task2.composite.PartType;
import yan.epam.task2.cor.BaseParser;


public class SymbolParser implements BaseParser
{
    @Override
    public void parse(Component lexemeComposite,String lexeme)
    {
        for (int i = 0; i < lexeme.length(); i++)
        {
            String s = String.valueOf(lexeme.charAt(i));
            if (s.matches("\\w"))
            {
                Component leaf=new Leaf(s.charAt(0),PartType.LETTER);
                lexemeComposite.add(leaf);
            }
            else
            {
                Component leaf=new Leaf(s.charAt(0),PartType.SYMBOL);
                lexemeComposite.add(leaf);
            }
        }
    }

}
