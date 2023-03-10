package dataBase.dbUtils;


import dataBase.beans.CBS_MusteriBean;
import dataProviders.ConfigReader;
import oracle.jdbc.driver.OracleConnection;

import java.sql.*;
import java.util.Properties;

public class JDBCOracle extends BeansClasses {

    final static String DB_URL = ConfigReader.getProperty("dataBaseURL");
    final static String DB_USER = ConfigReader.getProperty("dbUserName");
    final static String DB_PASSWORD = ConfigReader.getProperty("dbPassword");

    public static Connection connect() {
        Properties properties = new Properties();
        properties.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
        properties.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
        properties.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");
        try {
            connection = DriverManager.getConnection(DB_URL, properties);
            if (connection != null) {
                System.out.println("Connected with connection");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


//    public static void createConnection(){
//        connection = connect();
//    }

    private static Connection connection = connect();

    public static ResultSet query(String sqlQuery) {
        Connection connection = JDBCOracle.connection;
        try {
            return connection.createStatement().executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        createConnection();
//        CBS_Erisim_RolBeaqn random = CBS_Erisim_RolBean.getRandomRow();
//        System.out.println(random.getERISIM_KULLANICI_KODU());
//        System.out.println(random.getROL_NUMARA());
//        System.out.println(random.getBOLUM_KODU());
//        CBS_MusteriBean random1 = CBS_MusteriBean.getRandomRow();
//        System.out.println(random1.getMUSTERI_NO());
//        int a = CBS_MusteriBean.getRandomRow();
//        CBS_MusteriBean random = CBS_MusteriBean.getRandomRow();
        System.out.println(CBS_MusteriBean.cbs_musteriBean.getMUSTERI_NO());
        System.out.println(CBS_MusteriBean.cbs_musteriBean.getDOGUM_TARIHI());
//        System.out.println(CBS_MusteriBean.getRandomRow().getMUSTERI_NO());
//        System.out.println(CBS_MusteriBean.getRandomRow().getDOGUM_TARIHI());

//        CBS_MusteriBean cbsMusteriBean = new CBS_MusteriBean();
//        CBS_MusteriBean random1 = cbsMusteriBean.getRandomRow();
//        System.out.println(random1.getMUSTERI_NO());
    }


}
