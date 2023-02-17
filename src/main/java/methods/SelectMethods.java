package methods;


import mockData.JavaFakerData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectMethods {







    public int countOfSQLQuery(Connection connection, String sqlQuery, int columnNumber) throws SQLException {
        List<String> emailCustomers = new ArrayList<>();
        ResultSet resultSet = query(connection,sqlQuery);
        while (resultSet.next())
            emailCustomers.add(resultSet.getString(columnNumber));
        return emailCustomers.size();
    }

    public String getRandomFromList(Connection connection, String sqlQuery, int columnNumber) throws SQLException {
        List<String> emailCustomers = new ArrayList<>();
        ResultSet resultSet = query(connection,sqlQuery);
        while (resultSet.next())
            emailCustomers.add(resultSet.getString(columnNumber));
        return emailCustomers.get( JavaFakerData.getRandomNumber(emailCustomers.size()));
    }

    public static ResultSet query(Connection connection, String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sqlQuery);
    }



}
