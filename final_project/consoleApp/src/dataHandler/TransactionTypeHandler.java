package dataHandler;

import dataClasses.TransactionType;

public class TransactionTypeHandler {

    public static TransactionType getTransactionTypeByID(byte id) {
        for (TransactionType transactionType : Controller.getTransactionTypes()) {
            if (transactionType.getId() == id) {
                return transactionType;
            }
        }
        System.out.printf("Transaction type with id %d not found.\n", id);
        return null;
    }

    public static TransactionType getLastTransactionType() {
        return Controller.getTransactionTypes().get(Controller.getTransactionTypes().size() - 1);
    }

    public static void showTransactionTypes() {
        for (TransactionType transactionType : Controller.getTransactionTypes()) {
            System.out.println(transactionType.toString());
        }
    }
}
