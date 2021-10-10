package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends BaseHandler{
    private static final String REF_EXP_PARAGRAPH = "(\\.\\.\\.)|(!\\?)|(\\?!)|[.!?]";

    @Override
    public Component handle(String data) {
        Composite paragraph = new Composite(ComponentId.PARAGRAPH);
        String [] sentences = parseSentence(data);
        for (String sentence : sentences){
            Component sentenceComponent = this.getNext().handle(sentence);
            paragraph.add(sentenceComponent);
        }
        return paragraph;
    }

    private String [] parseSentence(String paragraph) {
        Pattern patternNewSentence = Pattern.compile(REF_EXP_PARAGRAPH);
        Matcher matcherSentence = patternNewSentence.matcher(paragraph);
        List<String> sentences = new ArrayList<>();
        int strIndex = 0; // индекс для выделения предложений
        while (matcherSentence.find()){
            sentences.add(paragraph.substring(strIndex,matcherSentence.end()));
            strIndex = matcherSentence.end()+1;
        }
        return sentences.toArray(new String[0]);
    }
}
