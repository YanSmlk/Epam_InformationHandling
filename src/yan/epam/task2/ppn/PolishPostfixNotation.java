package yan.epam.task2.ppn;

import org.apache.logging.log4j.Level;
import java.util.ArrayDeque;
import static yan.epam.task2.creation.TextCreator.LOGGER;


public class PolishPostfixNotation
{
    final private int i=5;
    final private int j=17;
    final private String NUMBER = "[0-9]";
    final private String SYMBOL = "[^0-9)]";
    final private String INC_I = "(\\+\\+i)|(i\\+\\+)";
    final private String DEC_I = "(--i)|(i--)";
    final private String INC_J = "(\\+\\+j)|(j\\+\\+)";
    final private String DEC_J = "(--j)|(j--)";


    public String calcExpr(String mathExpr)
    {
        mathExpr = formatExpression(mathExpr);
        StringBuilder resultStr = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < mathExpr.length(); index++)
        {
            char symb = mathExpr.charAt(index);
            if (String.valueOf(symb).matches(NUMBER))
            {
                resultStr.append(" ");
                resultStr.append(symb);
                int chainOfNumbers = 0;
                for (int newIndex = index + 1; newIndex < mathExpr.length(); newIndex++)
                {
                    char nextSymbol = mathExpr.charAt(newIndex);
                    if (String.valueOf(nextSymbol).matches(NUMBER))
                    {
                        chainOfNumbers++;
                        resultStr.append(nextSymbol);
                    }
                    else
                    {
                        break;
                    }
                }
                index += chainOfNumbers;
            }
            else if (symb == '(')
            {
                stack.push(symb);
            }
            else if (symb == ')')
            {
                while (true)
                {
                    char symbolFromStack = stack.pop();
                    if (symbolFromStack == '(')
                    {
                        break;
                    }
                    else
                    {
                        resultStr.append(" ");
                        resultStr.append(symbolFromStack);
                    }
                }
            } else
                {
                if (stack.isEmpty())
                {
                    stack.push(symb);
                } else
                    {
                    int priorityOfSymbol = getSymbPriority(symb);
                    while (true)
                    {
                        int priorityOfSymbolFromStack = getSymbPriority(stack.getFirst());

                        if (priorityOfSymbol > priorityOfSymbolFromStack)
                        {
                            stack.push(symb);
                            break;
                        } else
                            {
                            resultStr.append(" ");
                            resultStr.append(stack.pop());
                        }
                        if (stack.isEmpty())
                        {
                            stack.push(symb);
                            break;
                        }
                    }
                }
            }
        }
        while (stack.size() > 0)
        {
            resultStr.append(" ");
            resultStr.append(stack.pop());
        }
        LOGGER.log(Level.INFO,"Expression converted: "+resultStr.toString().trim());
        return resultStr.toString().trim();
    }

    public String formatExpression(String mathExpr)
    {
        mathExpr = mathExpr.replaceAll(INC_I, String.valueOf(i+1));
        mathExpr = mathExpr.replaceAll(DEC_I, String.valueOf(i-1));
        mathExpr = mathExpr.replaceAll(INC_J, String.valueOf(j+1));
        mathExpr = mathExpr.replaceAll(DEC_J, String.valueOf(j-1));
        mathExpr = String.join("", mathExpr.split("\\s"));
        StringBuilder strBld = new StringBuilder();
        for (int index = 0; index < mathExpr.length(); index++)
        {
            char symb = mathExpr.charAt(index);
            if (symb == '-')
            {
                if (index == 0)
                {
                    strBld.append(0);
                    strBld.append(symb);
                }
                else
                {
                    char preSymbol = mathExpr.charAt(index - 1);
                    if (String.valueOf(preSymbol).matches(SYMBOL))
                    {
                        strBld.append(0);
                        strBld.append(symb);
                    }
                    else
                    {
                        strBld.append(symb);
                    }
                }
            }
            else
            {
                strBld.append(symb);
            }
        }
        return strBld.toString();
    }

 private int getSymbPriority(char operation)
    {
        switch (operation)
        {
            case '/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
            case '(':
                return 0;
            default:
                return 0;
        }
    }

}
