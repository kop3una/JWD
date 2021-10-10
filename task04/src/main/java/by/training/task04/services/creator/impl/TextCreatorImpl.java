package by.training.task04.services.creator.impl;

import by.training.task04.beans.Sentence;
import by.training.task04.beans.Text;
import by.training.task04.beans.Word;
import by.training.task04.dao.DaoFactory;
import by.training.task04.dao.TextDao;
import by.training.task04.dao.exception.DaoException;
import by.training.task04.services.creator.TextCreator;
import by.training.task04.services.exception.ServicesException;

public class TextCreatorImpl implements TextCreator {
    private static final String HEADER = "Заголовок:";
    @Override
    public Text createFromFile(String fileName) throws ServicesException {
        TextDao textDao = DaoFactory.getInstance().getTextDao();
        try {
            String [][] dataFromFile = textDao.readFromFile(fileName);
            return convertArrStringToText(dataFromFile);
        } catch (DaoException e) {
            throw new ServicesException(e);
        }

    }

    @Override
    public Text createFromArr(String[][] array) {
        return convertArrStringToText(array);
    }

    private boolean checkHeader (String [] words, Text text){
        Sentence sentence = new Sentence();
        if (words[0].equals(HEADER)) {
            for (int currWord = 1; currWord < words.length; currWord++) {
                Word word = new Word();
                word.setValue(words[currWord]);
                sentence.addWord(word);
                sentence.addSpace();
            }
        }
        text.setHeader(sentence);
        return true;
    }

    private Text convertArrStringToText (String [][] array){
        Text text = new Text();
        int row = 0;
        if (checkHeader(array[0],text)){
            row = 1;
        }

        for (; row < array.length; row++){
            String [] words = array[row];
            Sentence sentence = new Sentence();
            for (String s : words) {
                Word word = new Word();
                word.setValue(s);
                sentence.addWord(word);
                sentence.addSpace();
            }
            text.addBody(sentence);
            text.addLineBreak();
        }
        return text;
    }
}
