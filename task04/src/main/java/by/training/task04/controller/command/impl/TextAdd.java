package by.training.task04.controller.command.impl;

import by.training.task04.beans.Sentence;
import by.training.task04.beans.Text;
import by.training.task04.controller.command.Command;
import by.training.task04.services.parse.ParseString;

public class TextAdd implements Command {
    @Override
    public Text execute(Object... arguments) {
        ParseString parseString = new ParseString();
        Sentence sentence = new Sentence();
        sentence = parseString.getSentence(arguments[0].toString());
        Text text = (Text) arguments[1];
        text.addBody(sentence);
        text.addLineBreak();
        return text;
    }
}
