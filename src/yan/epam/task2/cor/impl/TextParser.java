package yan.epam.task2.cor.impl;

import yan.epam.task2.composite.Component;
import yan.epam.task2.cor.BaseParser;

public class TextParser implements BaseParser
{
    private SymbolParser symbPar;
    private LexemeParser lexPar;
    private SentenceParser sentPar;
    private ParagraphParser parPars;
    Component textComposite;

    public TextParser()
    {
        symbPar=new SymbolParser();
        lexPar=new LexemeParser(symbPar);
        sentPar=new SentenceParser(lexPar);
        parPars=new ParagraphParser(sentPar);
    }

    public Component getTextComposite()
    {return textComposite;}

    @Override
    public void parse(Component textComposite ,String text)
    {
        if (parPars!=null)
        {
            parPars.parse(textComposite,text);
        }
        this.textComposite=textComposite;
    }

}

