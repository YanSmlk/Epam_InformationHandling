package yan.epam.task2.cor.impl;

import org.apache.logging.log4j.Level;
import yan.epam.task2.composite.Component;
import yan.epam.task2.composite.CompositeTool;
import yan.epam.task2.composite.PartType;
import yan.epam.task2.cor.BaseParser;
import yan.epam.task2.exception.IncorrectDataException;
import yan.epam.task2.interpreter.ExpressionCalculator;
import yan.epam.task2.ppn.PolishPostfixNotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static yan.epam.task2.creation.TextCreator.LOGGER;

public class LexemeParser implements BaseParser
{
    private SymbolParser symbPar;
    final String LEXEME_REGEX="\\s";
    final String MATH_EXPRESSION_REGEX="(--)|(\\+\\+)|(\\d)|([+*/])";

    public LexemeParser(SymbolParser symbPar)
    {
        this.symbPar = symbPar;
    }

    @Override
    public void parse(Component sentenceComposite,String sentence)
    {
        ExpressionCalculator expCalc;
        Component lexemeComposite;
        PolishPostfixNotation ppn=new PolishPostfixNotation();
        Pattern pattern = Pattern.compile(MATH_EXPRESSION_REGEX);
        String[] lexems =sentence.split(LEXEME_REGEX);
        for (String lexeme : lexems)
        {
            Matcher matcher = pattern.matcher(lexeme);
            if (matcher.find())
            {
                try
                {
                    lexeme = ppn.calcExpr(lexeme);
                    expCalc = new ExpressionCalculator();
                    expCalc.addOperations(lexeme);
                    lexeme = expCalc.calcExpression();
                    lexemeComposite = new CompositeTool(PartType.LEXEME);
                    symbPar.parse(lexemeComposite, lexeme);
                    sentenceComposite.add(lexemeComposite);
                }
                catch (IncorrectDataException ex)
                {
                    LOGGER.log(Level.ERROR,ex.getMessage());
                }
            }
            else
            {
                lexemeComposite=new CompositeTool(PartType.LEXEME);
                symbPar.parse(lexemeComposite,lexeme);
                sentenceComposite.add(lexemeComposite);
            }
        }
    }

}
