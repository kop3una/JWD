package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexemeHandler extends BaseHandler{
    private static final String REG_EXP_PUNCTUATION_MARK = "(!\\?)|(\\?!)|(\\.\\.\\.)|[.?!,:;]";


    @Override
    public Component handle(String data) {
        Composite lexeme = new Composite(ComponentId.LEXEME);
        String [] words = parseWord(data);
        for (String word : words){
            Component wordComponent = this.getNext().handle(word);
            lexeme.add(wordComponent);
        }
        return lexeme;
    }

    private String [] parseWord(String word) {
        Pattern patternNewWord = Pattern.compile(REG_EXP_PUNCTUATION_MARK);
        Matcher matcherNewWord = patternNewWord.matcher(word);
        if (matcherNewWord.find()){
            return new String[]{word.substring(0,matcherNewWord.start()), word.substring(matcherNewWord.start())};
        } else {
            return new String[]{word};
        }
    }

}
