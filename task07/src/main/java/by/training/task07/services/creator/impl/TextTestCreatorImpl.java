package by.training.task07.services.creator.impl;

import by.training.task07.beans.Component;
import by.training.task07.dao.DaoFactory;
import by.training.task07.dao.TextDao;
import by.training.task07.dao.exception.DaoException;
import by.training.task07.services.chainofresponsible.*;
import by.training.task07.services.creator.TextCreator;
import by.training.task07.services.exception.ServicesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextTestCreatorImpl implements TextCreator {
    private final Logger logger = LogManager.getLogger(TextCreatorImpl.class);
    @Override
    public Component createFromFile(String fileName) throws ServicesException {
        TextDao textDao = DaoFactory.getInstance().getTextTestDao();
        try {
            String textStr = textDao.readFromFile(fileName);
            Handler textHandler = new TextHandler();
            Handler paragraphHandler = new ParagraphHandler();
            Handler sentenceHandler = new SentenceHandler();
            Handler lexemeHandler = new LexemeHandler();
            Handler wordHandler = new WordHandler();
            Handler symbolHandler = new SymbolHandler();
            textHandler.setNext(paragraphHandler);
            paragraphHandler.setNext(sentenceHandler);
            sentenceHandler.setNext(lexemeHandler);
            lexemeHandler.setNext(wordHandler);
            wordHandler.setNext(symbolHandler);
            return textHandler.handle(textStr);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServicesException(e);
        }

    }
}
