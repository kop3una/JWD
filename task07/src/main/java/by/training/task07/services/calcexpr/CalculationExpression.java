package by.training.task07.services.calcexpr;

import java.util.Stack;
import java.util.regex.Pattern;

public class CalculationExpression {
    private static final String REG_EXP_DIGIT = "\\d+";
    private static final String REG_EXP_SYMBOL = "(\\d+)|(<+)|(>+)|[()|&~^]";
    private static final String REG_EXP_SPACE = "\\s+";
    private int i;
    private final Stack<String> stack = new Stack<>();

    private int relativePriority(String symbol) {
        if (isDigit(symbol)) {
            return 13;
        } else {
            switch (symbol) {
                case ("|"):
                    return 1;
                case ("^"):
                    return 3;
                case ("&"):
                    return 5;
                case ("<<"):
                case (">>"):
                case (">>>"):
                    return 7;
                case ("~"):
                    return 9;
                case ("("):
                    return 20;
                case (")"):
                default:
                    return 0;
            }
        }
    }

    private int stackPriority(String symbol) {
        if (isDigit(symbol)) {
            return 14;
        } else {
            switch (symbol) {
                case ("|"):
                    return 2;
                case ("^"):
                    return 4;
                case ("&"):
                    return 6;
                case ("<<"):
                case (">>"):
                case (">>>"):
                    return 8;
                case ("~"):
                    return 10;
                case ("("):
                default:
                    return 0;
            }
        }
    }

    private boolean isDigit(String symbol) {
        return symbol.matches(REG_EXP_DIGIT);
    }

    private String getSymbol(char[] expression) {
        StringBuilder symbol = new StringBuilder();
        symbol.setLength(0);
        if (i != expression.length){
            symbol.append(expression[i]);
            while (symbol.toString().matches(REG_EXP_SYMBOL) && (i + 1) != expression.length) {
                i++;
                symbol.append(expression[i]);
            }

            if (!symbol.toString().matches(REG_EXP_SYMBOL)) {
                symbol.deleteCharAt(symbol.length() - 1);
                i--;
            }
        }
        return symbol.toString();
    }

    public String makePolishString(String s) {
        int relativePriority;
        int stackPriority;
        char[] expression = s.toCharArray();
        i = 0;

        StringBuilder result = new StringBuilder();

        String symbol = getSymbol(expression);
        i++;
        stack.push(symbol);
        stackPriority = stackPriority(symbol);
        symbol = getSymbol(expression);
        while (!stack.empty() && i < s.length()) {
            i++;
            relativePriority = relativePriority(symbol);
            while (relativePriority < stackPriority) {
                result.append(stack.pop()).append(" ");
                if (stack.empty()) {
                    stack.push(symbol);
                    stackPriority = relativePriority;
                } else {
                    String helpSymbol = stack.pop();
                    stackPriority = stackPriority(helpSymbol);
                    stack.push(helpSymbol);
                }
            }

            if (relativePriority > stackPriority) {
                stack.push(symbol);
            }

            if (symbol.equals(")")) {
                stack.pop();
            }

            symbol = getSymbol(expression);

            if (!stack.empty()) {
                String helpSymbol = stack.pop();
                stackPriority = stackPriority(helpSymbol);
                stack.push(helpSymbol);
            } else {
                stack.push(symbol);
                stackPriority = stackPriority(symbol);
                i++;
                symbol = getSymbol(expression);
            }

        }

        while (!stack.empty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString();
    }

    public int calculateExpression (String s){
        String [] symbols = Pattern.compile(REG_EXP_SPACE).split(s);
        String symbol1;
        String symbol2;
        for (String symbol : symbols) {
            if (isDigit(symbol)) {
                stack.push(symbol);
            } else {
                switch (symbol) {
                    case ("~"):
                        symbol1 = stack.pop();
                        stack.push(String.valueOf(~Integer.parseInt(symbol1)));
                        break;
                    case ("^"):
                        symbol1 = stack.pop();
                        symbol2 = stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(symbol1) ^ Integer.parseInt(symbol2)));
                        break;
                    case ("&"):
                        symbol1 = stack.pop();
                        symbol2 = stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(symbol1) & Integer.parseInt(symbol2)));
                        break;
                    case ("|"):
                        symbol1 = stack.pop();
                        symbol2 = stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(symbol1) | Integer.parseInt(symbol2)));
                        break;
                    case ("<<"):
                        symbol1 = stack.pop();
                        symbol2 = stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(symbol1) << Integer.parseInt(symbol2)));
                        break;
                    case (">>"):
                        symbol1 = stack.pop();
                        symbol2 = stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(symbol1) >> Integer.parseInt(symbol2)));
                        break;
                    case (">>>"):
                        symbol1 = stack.pop();
                        symbol2 = stack.pop();
                        stack.push(String.valueOf(Integer.parseInt(symbol1) >>> Integer.parseInt(symbol2)));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
