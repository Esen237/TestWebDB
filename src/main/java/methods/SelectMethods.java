package methods;


import dataBase.dbUtils.JDBCOracle;
import mockData.JavaFakerData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectMethods {


    public int countOfSQLQuery( String sqlQuery, int columnNumber) throws SQLException {
        List<String> emailCustomers = new ArrayList<>();
        ResultSet resultSet = JDBCOracle.query(sqlQuery);
        while (resultSet.next())
            emailCustomers.add(resultSet.getString(columnNumber));
        return emailCustomers.size();
    }

    public String getRandomFromList( String sqlQuery, int columnNumber) throws SQLException {
        List<String> emailCustomers = new ArrayList<>();
        ResultSet resultSet = JDBCOracle.query(sqlQuery);
        while (resultSet.next())
            emailCustomers.add(resultSet.getString(columnNumber));
        return emailCustomers.get( JavaFakerData.getRandomNumber(emailCustomers.size()));
    }



}
