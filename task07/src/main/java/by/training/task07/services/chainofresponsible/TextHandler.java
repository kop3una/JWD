package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextHandler extends BaseHandler{
    private static final String REG_EXP_TEXT = "(\\n)|(\\r\\n)|(\\r)|(\\s{4})";

    @Override
    public Component handle(String data) {
        Composite text = new Composite(ComponentId.TEXT);
        String [] paragraphs = parseParagraph(data);
        for (String paragraph : paragraphs){
            Component paragraphComponent = this.getNext().handle(paragraph);
            text.add(paragraphComponent);
        }
        return text;
    }

    private String [] parseParagraph(String text) {
        Pattern patternNewParagraph = Pattern.compile(REG_EXP_TEXT);
        String [] paragraphs = patternNewParagraph.split(text);
        List<String> correctParagraph = new ArrayList<>();
        for (String paragraph : paragraphs){
            if (!paragraph.isEmpty()){
                correctParagraph.add(paragraph);
            }
        }
        return correctParagraph.toArray(new String[0]);
    }
}
