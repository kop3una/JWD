package by.training.task07test.text;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;
import by.training.task07.beans.Leaf;
import by.training.task07.services.calcexpr.CalculationExpressionInText;
import by.training.task07.services.creator.CreatorFactory;
import by.training.task07.services.creator.TextCreator;
import by.training.task07.services.exception.ServicesException;
import by.training.task07.services.sorting.SortLexeme;
import by.training.task07.services.sorting.SortParagraph;
import by.training.task07.services.sorting.SortWord;
import by.training.task07.services.sorting.SortingText;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextTest {
    @DataProvider(name = "text1")
    public Object[][] createText1() throws ServicesException {
        TextCreator textCreator = CreatorFactory.getInstance().getTextTestCreator();
        Component text = textCreator.createFromFile("text1");
        Composite textHandMade = new Composite(ComponentId.TEXT);
        Composite paragraph = new Composite(ComponentId.PARAGRAPH);
        textHandMade.add(paragraph);
        Composite firstSentence = new Composite(ComponentId.SENTENCE);
        paragraph.add(firstSentence);
        Composite firstSentenceFirstLexeme = new Composite(ComponentId.LEXEME);
        Composite firstSentenceSecondLexeme = new Composite(ComponentId.LEXEME);
        firstSentence.add(firstSentenceFirstLexeme);
        firstSentence.add(firstSentenceSecondLexeme);

        Composite firstSentenceFirstLexemeWord = new Composite(ComponentId.WORD);
        firstSentenceFirstLexeme.add(firstSentenceFirstLexemeWord);
        Leaf b = new Leaf(ComponentId.SYMBOL);
        b.setValue('B');
        Leaf y = new Leaf(ComponentId.SYMBOL);
        y.setValue('y');
        Leaf e = new Leaf(ComponentId.SYMBOL);
        e.setValue('e');
        firstSentenceFirstLexemeWord.add(b);
        firstSentenceFirstLexemeWord.add(y);
        firstSentenceFirstLexemeWord.add(e);

        Composite firstSentenceSecondLexemeFirstWord = new Composite(ComponentId.WORD);
        Composite firstSentenceSecondLexemeSecondWord = new Composite(ComponentId.WORD);
        firstSentenceSecondLexeme.add(firstSentenceSecondLexemeFirstWord);
        firstSentenceSecondLexeme.add(firstSentenceSecondLexemeSecondWord);

        Leaf k = new Leaf(ComponentId.SYMBOL);
        k.setValue('K');
        Leaf i1 = new Leaf(ComponentId.SYMBOL);
        i1.setValue('i');
        Leaf r = new Leaf(ComponentId.SYMBOL);
        r.setValue('r');
        Leaf i2 = new Leaf(ComponentId.SYMBOL);
        i2.setValue('i');
        Leaf l1 = new Leaf(ComponentId.SYMBOL);
        l1.setValue('l');
        Leaf l2 = new Leaf(ComponentId.SYMBOL);
        l2.setValue('l');

        firstSentenceSecondLexemeFirstWord.add(k);
        firstSentenceSecondLexemeFirstWord.add(i1);
        firstSentenceSecondLexemeFirstWord.add(r);
        firstSentenceSecondLexemeFirstWord.add(i2);
        firstSentenceSecondLexemeFirstWord.add(l1);
        firstSentenceSecondLexemeFirstWord.add(l2);

        Leaf punctMark = new Leaf(ComponentId.SYMBOL);
        punctMark.setValue('!');
        firstSentenceSecondLexemeSecondWord.add(punctMark);
        return
                new Object[][]{
                        {text, textHandMade},
                };
    }

    @DataProvider(name = "text2")
    public Object[][] createText() throws ServicesException {
        TextCreator textCreator = CreatorFactory.getInstance().getTextTestCreator();
        Component text1 = textCreator.createFromFile("text2");
        CalculationExpressionInText calculationExpressionInText = new CalculationExpressionInText();
        calculationExpressionInText.calculateExpr(text1);

        Component text2 = textCreator.createFromFile("text2");

        Component text3 = textCreator.createFromFile("text2");
        SortingText sortingText3 = new SortWord();
        sortingText3.sort(text3);

        Component text4 = textCreator.createFromFile("text2");
        SortingText sortingText4 = new SortLexeme('e');
        sortingText4.sort(text4);

        Component text5 = textCreator.createFromFile("text2");
        SortingText sortingText5 = new SortParagraph();
        sortingText5.sort(text5);

        Component text6 = textCreator.createFromFile("text2");
        calculationExpressionInText.calculateExpr(text6);
        SortingText sortingText6 = new SortParagraph();
        sortingText6.sort(text6);

        return
                new Object[][]{
                        {text1, "Bye. \r\n" +
                                "It is a 1213 westablished fact that a reader will be of a page when looking at its layout. \r\n" +
                                "It has survived - not only (five) centuries, but also the leap into 16384 electronic typesetting, remaining 0 essentially 9 unchanged. It was popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Hay i'm Kirill! Hay i'm Kirill... Hay i'm Kirill? Hay i'm Kirill?! Hay i'm Kirill!? \r\n" +
                                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English. \r\n"},
                        {text2, "Bye. \r\n" +
                                "It is a (8^5|1&2<<(2|5>>2&71))|1200 westablished fact that a reader will be of a page when looking at its layout. \r\n" +
                                "It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 30>>>3 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Hay i'm Kirill! Hay i'm Kirill... Hay i'm Kirill? Hay i'm Kirill?! Hay i'm Kirill!? \r\n" +
                                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English. \r\n"},
                        {text3, "Bye. \r\n" +
                                "a a a It is be of at its fact that will page when reader layout. looking westablished (8^5|1&2<<(2|5>>2&71))|1200 \r\n" +
                                "- It has not but the only also leap into 13<<2 (five) 30>>>3 survived centuries, remaining unchanged. electronic ~6&9|(3&4) typesetting, essentially It in of of was the the and with more with like Lorem Ipsum Aldus Lorem Ipsum. sheets release desktop Letraset passages, recently software versions PageMaker including containing publishing popularised 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) Hay i'm Kirill! Hay i'm Kirill... Hay i'm Kirill? Hay i'm Kirill?! Hay i'm Kirill!? \r\n" +
                                "a a a It is be by of at the its long fact that will page when reader layout. content looking readable distracted established a of is it of as to it The has that look like point using Ipsum using here), here', normal making letters, opposed content English. (Content readable more-or-less distribution (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 \r\n"},
                        {text4, "Bye. \r\n" +
                                "reader westablished be page when (8^5|1&2<<(2|5>>2&71))|1200 a a a at fact is It its layout. looking of that will \r\n" +
                                "centuries, electronic essentially typesetting, (five) leap remaining survived the unchanged. - 13<<2 30>>>3 also but has into It not only ~6&9|(3&4) release Letraset PageMaker recently sheets desktop like Lorem Lorem more passages, popularised software the the versions 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) Aldus and containing in including Ipsum Ipsum. It of of publishing was with with Hay i'm Kirill! Hay i'm Kirill... Hay i'm Kirill? Hay i'm Kirill?! Hay i'm Kirill!? \r\n" +
                                "established readable reader be content distracted page the when a a a at by fact is It its layout. long looking of that will here', here), letters, more-or-less readable (Content content like opposed The (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 a as distribution English. has Ipsum is it it look making normal of of point that to using using \r\n"},
                        {text5, "It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 30>>>3 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Hay i'm Kirill! Hay i'm Kirill... Hay i'm Kirill? Hay i'm Kirill?! Hay i'm Kirill!? \r\n" +
                                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English. \r\n" +
                                "Bye. \r\n" +
                                "It is a (8^5|1&2<<(2|5>>2&71))|1200 westablished fact that a reader will be of a page when looking at its layout. \r\n"},
                        {text6, "It has survived - not only (five) centuries, but also the leap into 16384 electronic typesetting, remaining 0 essentially 9 unchanged. It was popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Hay i'm Kirill! Hay i'm Kirill... Hay i'm Kirill? Hay i'm Kirill?! Hay i'm Kirill!? \r\n" +
                                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English. \r\n" +
                                "Bye. \r\n" +
                                "It is a 1213 westablished fact that a reader will be of a page when looking at its layout. \r\n"},
                };
    }

    @Test(description = "Make_object_handmade",
            dataProvider = "text1")
    public void testHandMadeObject(Composite o1, Composite o2) {
        Assert.assertEquals(o1, o2);
    }

    @Test(description = "Calc_Expr_in_text",
            dataProvider = "text2")
    public void testText(Component text,String result){
        Assert.assertEquals(text.collect(),result);
    }
}
