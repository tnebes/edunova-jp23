package IO.SQL;

import IO.IDCounter;
import dataClasses.*;
import dataHandler.*;

import java.sql.*;
import java.text.DateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class GetterSetter {

    private static DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss")
            .withLocale(Locale.GERMAN)
            .withZone(ZoneId.of("UTC"));

    static void updateArticles() {
        SQLCommunicator.sendQuery("DELETE FROM article;");
        for (dataClasses.Article article : Controller.getArticles()) {
            SQLCommunicator.sendQuery(sendArticleToDB(article));
        }
    }

    static void getArticlesFromDB() {
        ResultSet resultSet = SQLCommunicator.getSQLItems(SQLCommunicator.ARTICLES);
        ArrayList<Article> tempArticles = new ArrayList<>();
        try {
            int i;
            long counter = 0;
            while (resultSet.next()) {
                i = 1;
                Article tempArticle = new Article(
                        resultSet.getInt(i++), // id
                        resultSet.getString(i++), // warehouse_location
                        resultSet.getInt(i++), // warehouse_quantity
                        resultSet.getFloat(i++), // wholesale_price
                        resultSet.getFloat(i++), // retail_price
                        resultSet.getByte(i++), // tax_rate
                        resultSet.getString(i++), // short_name
                        resultSet.getString(i++), // long_name
                        resultSet.getString(i++), // short_description
                        resultSet.getString(i++) // long_description
                );
                if (tempArticle.getId() > counter) {
                    counter = tempArticle.getId();
                }
                tempArticles.add(tempArticle);
            }
            Controller.setArticles(tempArticles);
            IDCounter.setArticleCounter(counter);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String sendArticleToDB(Article article) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO article VALUES (");
        sb.append(article.getId()).append(","); // id
        sb.append(SQLCommunicator.parseDataAsString(article.getWarehouseLocation())).append(","); // warehouse_location
        sb.append(article.getWarehouseQuantity()).append(","); // warehouse_quantity
        sb.append(article.getWholesalePrice()).append(","); // wholesale_price
        sb.append(article.getRetailPrice()).append(","); // retail_price
        sb.append(article.getTaxRate()).append(","); // tax_rate
        sb.append(SQLCommunicator.parseDataAsString(article.getShortName())).append(","); // short_name
        sb.append(SQLCommunicator.parseDataAsString(article.getLongName())).append(","); // long_name
        sb.append(SQLCommunicator.parseDataAsString(article.getShortDescription())).append(","); // short_description
        sb.append(SQLCommunicator.parseDataAsString(article.getLongDescription())).append(");"); // long_description
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static String sendAddressToDB(Address address) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO address VALUES (");
        sb.append(address.getId()).append(",");
        sb.append(address.isType() ? "1" : "0").append(",");
        sb.append(SQLCommunicator.parseDataAsString(address.getCity())).append(",");
        sb.append(SQLCommunicator.parseDataAsString(address.getZIPCode())).append(",");
        sb.append(SQLCommunicator.parseDataAsString(address.getStreet())).append(",");
        sb.append(SQLCommunicator.parseDataAsString(address.getStreetNumber())).append(",");
        sb.append(SQLCommunicator.parseDataAsString(address.getStreetLetter())).append(",");
        sb.append(SQLCommunicator.parseDataAsString(address.getCountry())).append(");");
        System.out.println(sb.toString());
        return sb.toString();
    }

    static void updateAddresses() {
        SQLCommunicator.sendQuery("DELETE FROM address;");
        for (dataClasses.Address address : Controller.getAddresses()) {
            SQLCommunicator.sendQuery(sendAddressToDB(address));
        }
    }

    static void getAddressesFromDB() {
        ResultSet resultSet = SQLCommunicator.getSQLItems(SQLCommunicator.ADDRESSES);
        ArrayList<Address> tempAddresses = new ArrayList<>();
        try {
            int i;
            long counter = 0;
            while (resultSet.next()) {
                i = 1;
                Address tempAddress = new Address(
                        resultSet.getInt(i++), // id
                        resultSet.getBoolean(i++), // type
                        resultSet.getString(i++), // city
                        resultSet.getString(i++), // ZIP_code
                        resultSet.getString(i++), // street
                        resultSet.getString(i++), // street_number
                        resultSet.getString(i++), // street_letter
                        resultSet.getString(i++) // country
                );
                if (tempAddress.getId() > counter) {
                    counter = tempAddress.getId();
                }
                tempAddresses.add(tempAddress);
            }
            Controller.setAddresses(tempAddresses);
            IDCounter.setAddressCounter(counter);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void updateInvoices() {
        SQLCommunicator.sendQuery("DELETE FROM invoice;");
        for (dataClasses.Invoice invoice : Controller.getInvoices()) {
            SQLCommunicator.sendQuery(sendInvoiceToDB(invoice));
        }
    }

    private static String sendInvoiceToDB(Invoice invoice) {
        StringBuilder sb = new StringBuilder("INSERT INTO invoice VALUES(");
        sb.append(invoice.getId()).append(","); // id
        // BUG: this doesn't work
        // FIXME this entire class is just waiting for an SQL injection
        sb.append(SQLCommunicator.parseDataAsString(myDateTimeFormatter.format(invoice.getDateOfCreation()))).append(","); // date_of_creation
        if (invoice.getCustomer() != null) {
            sb.append(invoice.getCustomer().getId()).append(","); // customer_id
        } else {
            // this is some next-level badness right there.
            // FIXME !!!
            sb.append(Types.NULL).append(","); // customer_id
        }
        sb.append(invoice.getTranscationTypeId().getId()).append(","); // transaction_type_id
        sb.append(invoice.getStatus().getId()).append(","); // status_id
        sb.append(invoice.getInvoiceDiscountPercent()).append(","); // invoice_discount_percent
        sb.append(invoice.getSubtotal()).append(","); // subtotal
        sb.append(invoice.getAmountDue()).append(","); // amount_due
        sb.append(invoice.getAmountPaid()).append(","); // amount_paid
        if (invoice.getShippingAddress() != null) {
            sb.append(invoice.getShippingAddress().getId()).append(");"); // shipping_address_id
        } else {
            // FIXME !!!
            // next-generation badness.
            sb.append(Types.NULL).append(");"); // shipping_address_id
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void getInvoicesFromDB() {
        ResultSet resultSet = SQLCommunicator.getSQLItems(SQLCommunicator.INVOICES);
        ArrayList<Invoice> tempInvoices = new ArrayList<>();
        try {
            int i;
            long counter = 0;
            while (resultSet.next()) {
                i = 1;
                Invoice tempInvoice = new Invoice(
                        resultSet.getInt(i++), // id
                        resultSet.getDate(i++).toInstant(), // date_of_creation
                        CustomerHandler.getCustomer(resultSet.getInt(i++)), // customer_id
                        TransactionTypeHandler.getTransactionTypeByID(resultSet.getByte(i++)), // transaction_type_id
                        StatusHandler.getStatusByID(resultSet.getByte(i++)), // status_id
                        resultSet.getByte(i++), // invoice_discount_percent
                        resultSet.getFloat(i++), // subtotal
                        resultSet.getFloat(i++), // amount_due
                        resultSet.getFloat(i++), // amount_paid
                        AddressHandler.getAddress(resultSet.getInt(i++)) // shipping_address_id
                );
                if (tempInvoice.getId() > counter) {
                    counter = tempInvoice.getId();
                }
                tempInvoices.add(tempInvoice);
            }
            Controller.setInvoices(tempInvoices);
            IDCounter.setInvoiceCounter(counter);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void getStatusesFromDB() {
        ResultSet resultSet = SQLCommunicator.getSQLItems(SQLCommunicator.STATUSES);
        ArrayList<Status> tempStatuses = new ArrayList<>();
        try {
            int i;
            byte counter = 0;
            while (resultSet.next()) {
                i = 1;
                Status tempStatus = new Status(
                        resultSet.getByte(i++), // id
                        resultSet.getString(i++), // name
                        resultSet.getString(i++), // description
                        resultSet.getString(i++) // description_long
                );
                if (tempStatus.getId() > counter) {
                    counter = tempStatus.getId();
                }
            }
            Controller.setStatuses(tempStatuses);
            IDCounter.setStatusCounter(counter);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void updateStatuses() {
        SQLCommunicator.sendQuery("DELETE FROM status;");
        for (Status status : Controller.getStatuses()) {
            SQLCommunicator.sendQuery(sendStatusToDB(status));
        }
    }

    private static String sendStatusToDB(Status status) {
        StringBuilder sb = new StringBuilder("INSERT INTO status VALUES (");
        sb.append(status.getId()).append(","); // id
        sb.append(SQLCommunicator.parseDataAsString(status.getName())).append(","); // name
        sb.append(SQLCommunicator.parseDataAsString(status.getDescription())).append(","); // description
        sb.append(SQLCommunicator.parseDataAsString(status.getDescriptionLong())).append(");"); // description_long
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void updateTransactionTypes() {
        SQLCommunicator.sendQuery("DELETE FROM transaction_type;");
        for (TransactionType transactionType : Controller.getTransactionTypes()) {
            SQLCommunicator.sendQuery(sendTransactionTypeToDB(transactionType));
        }
    }

    public static void getTransactionTypesFromDB() {
        ResultSet resultSet = SQLCommunicator.getSQLItems(SQLCommunicator.TRANSACTION_TYPES);
        ArrayList<TransactionType> tempTransactionTypes = new ArrayList<>();
        try {
            int i;
            byte counter = 0;
            while (resultSet.next()) {
                i = 1;
                TransactionType tempTransactionType = new TransactionType(
                        resultSet.getByte(i++), // id
                        resultSet.getString(i++), // name
                        resultSet.getString(i++) // description
                );
                tempTransactionTypes.add(tempTransactionType);
                if (tempTransactionType.getId() > counter) {
                    counter = tempTransactionType.getId();
                }
            }
            Controller.setTransactionTypes(tempTransactionTypes);
            IDCounter.setTransactionTypeCounter(counter);
        }catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private static String sendTransactionTypeToDB(TransactionType transactionType) {
        StringBuilder sb = new StringBuilder("INSERT INTO transaction_type VALUES (");
        sb.append(transactionType.getId()).append(","); // id
        sb.append(SQLCommunicator.parseDataAsString(transactionType.getName())).append(",");
        sb.append(SQLCommunicator.parseDataAsString(transactionType.getDescription())).append(");");
        System.out.println(sb.toString());
        return sb.toString();
    }



}
