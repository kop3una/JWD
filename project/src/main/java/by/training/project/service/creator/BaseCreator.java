package by.training.project.service.creator;

import by.training.project.dao.Transaction;

public abstract class BaseCreator {
    protected Transaction transaction = null;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
