package yan.epam.task2.action;

import yan.epam.task2.composite.Component;
import java.util.ArrayList;


public class TextOperation
{

    public static Component sortParagraphsBySentences(Component textComposite) //Paragraph sorting by sentencies count.
    {
        ArrayList<Component> paragraphs=textComposite.getComponents();
        sortComponents(paragraphs);
        return textComposite;
    }


    public static Component sortSentenciesByLexemes(Component textComposite) //Sentencies sorting by lexemes length.
    {
        for (Component paragraph : textComposite.getComponents())
        {
            for (Component sentence : paragraph.getComponents())
            {
                ArrayList<Component> lexemes = sentence.getComponents();
                sortComponents(lexemes);
            }
        }
        return textComposite;
    }

    public static Component removeWord(Component textComposite,String word)
    {
        ArrayList<Component> lexemesForDel = new ArrayList<>();
        for (Component paragraph : textComposite.getComponents())
        {
            for (Component sentence : paragraph.getComponents())
            {
                for (Component lexeme : sentence.getComponents())
                {
                    if(word.equals(lexeme.toString()))
                    {
                        lexemesForDel.add(lexeme);
                    }
                }
            }
        }
        if(!lexemesForDel.isEmpty())
        {
            for (Component paragraph : textComposite.getComponents())
            {
                for (Component sentence : paragraph.getComponents())
                {
                    for (int i = 0; i < lexemesForDel.size(); i++)
                    {
                        sentence.delete(lexemesForDel.get(i));
                    }
                }
            }
        }
        return textComposite;
    }


    public static void sortComponents( ArrayList<Component> components)
    {
        int count = components.size();
        for (int i = count - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                Component partJ = components.get(j);
                Component partJJ = components.get(j + 1);
                int partJLength = partJ.getComponents().size();
                int partJJLength = partJJ.getComponents().size();
                if (partJLength > partJJLength)
                {
                    ArrayList<Component> prePartJ = new ArrayList<>(partJ.getComponents());
                    ArrayList<Component> prePartJJ = new ArrayList<>(partJJ.getComponents());
                    for (Component prePart : prePartJ)
                    {
                        partJ.delete(prePart);
                        partJJ.add(prePart);
                    }
                    for (Component prePart : prePartJJ)
                    {
                        partJ.add(prePart);
                        partJJ.delete(prePart);
                    }
                }
            }
        }
    }


}




