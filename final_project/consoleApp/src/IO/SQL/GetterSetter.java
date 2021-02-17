package IO.SQL;

import IO.IDCounter;
import dataClasses.Address;
import dataClasses.Article;
import dataHandler.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetterSetter {
    static void updateArticles() {
        SQLCommunicator.sendQuery("DELETE FROM article");
        for (dataClasses.Article article : Controller.getArticles()) {
            SQLCommunicator.sendQuery(sendArticlesToDB(article));
        }
    }

    static void getArticles() {
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

    private static String sendArticlesToDB(Article article) {
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

    private static String sendAddressToDB(dataClasses.Address address) {
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
        SQLCommunicator.sendQuery("DELETE FROM address");
        for (dataClasses.Address address : Controller.getAddresses()) {
            SQLCommunicator.sendQuery(sendAddressToDB(address));
        }
    }

    static void getAddresses() {
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

}
