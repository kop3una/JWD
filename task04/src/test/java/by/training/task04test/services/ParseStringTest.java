package by.training.task04test.services;

import by.training.task04.beans.Sentence;
import by.training.task04.beans.Word;
import by.training.task04.services.parse.ParseString;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParseStringTest {  // TODO чек бефоре тест, добавить тестов для сервисов, коллекция для еста объекта
    @DataProvider(name = "parse_correct")
    public Object[][] createDataSortingIncrease() {
        Word hello = new Word();
        hello.setValue("hello");
        Word world = new Word();
        world.setValue("world");
        Sentence sentence1 = new Sentence();
        sentence1.addWord(hello);
        sentence1.addSpace();
        sentence1.addWord(world);
        sentence1.addSpace();
        return
                new Object[][]{
                        {"hello world", sentence1 },
                };
    }


    @Test(description = "Check_parse_sentence",
            dataProvider = "parse_correct")
    public void testParseString(String string, Sentence sentence){
        ParseString parseString = new ParseString();
        Sentence sentenceParse = parseString.getSentence(string);
        Assert.assertEquals(sentenceParse,sentence);
    }

}
