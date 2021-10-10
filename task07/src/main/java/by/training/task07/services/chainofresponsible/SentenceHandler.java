package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

import java.util.regex.Pattern;

public class SentenceHandler extends BaseHandler{
    private static final String REG_EXP_SENTENCE = "\\s+";


    @Override
    public Component handle(String data) {
        Composite sentence = new Composite(ComponentId.SENTENCE);
        String [] lexemes = parseLexemes(data);
        for (String lexeme : lexemes){
            Component lexemeComponent = this.getNext().handle(lexeme);
            sentence.add(lexemeComponent);
        }
        return sentence;
    }

    private String [] parseLexemes(String sentence) {
        Pattern patternNewLexemes = Pattern.compile(REG_EXP_SENTENCE);
        return patternNewLexemes.split(sentence);
    }

}
