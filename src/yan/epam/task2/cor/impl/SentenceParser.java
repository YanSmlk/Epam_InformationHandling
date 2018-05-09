package yan.epam.task2.cor.impl;

import yan.epam.task2.composite.Component;
import yan.epam.task2.composite.CompositeTool;
import yan.epam.task2.composite.PartType;
import yan.epam.task2.cor.BaseParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements BaseParser
{
    private LexemeParser lexPar;
    final String SENTENCE_REGEX="(?:[^!?.]|\\.(?=\\d))+[!?.]";

    public SentenceParser(LexemeParser lexPars)
    {
        this.lexPar = lexPars;
    }

    @Override
    public void parse(Component paragraphComposite, String paragraph)
    {
        String sentence;
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find())
        {
            if (lexPar!=null)
            {
                sentence=matcher.group().replaceAll("\\s+", " ").trim();
                Component sentenceComposite=new CompositeTool(PartType.SENTENCE);
                lexPar.parse(sentenceComposite,sentence);
                paragraphComposite.add(sentenceComposite);
            }
        }
    }



}


