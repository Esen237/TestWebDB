//package dataBase;
//
//import dataBase.dbUtils.BeansClasses;
//import dataProviders.ConfigReader;
//import oracle.jdbc.datasource.impl.OracleDataSource;
//import oracle.jdbc.driver.OracleConnection;
//import org.testng.Assert;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.Random;
//
//public class JDBCConnect extends BeansClasses {
//
//    final static String DB_URL = ConfigReader.getProperty("dataBaseURL");
//    final static String DB_USER = ConfigReader.getProperty("dbUserName");
//    final static String DB_PASSWORD = ConfigReader.getProperty("dbPassword");
//
//    public JDBCConnect() throws SQLException {
//    }
//
//
//    public static Connection connect() throws SQLException {
//        Properties info = new Properties();
//        info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
//        info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
//        info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");
//            OracleDataSource ods = new OracleDataSource();
//            ods.setURL(DB_URL);
//            ods.setConnectionProperties(info);
//        return ods.getConnection();
//    }
//
//    public static ResultSet query (String query) throws SQLException {
//            Statement statement = connect().createStatement();
//            return statement.executeQuery(query);
//    }
//
//
////    public static OracleDataSource oracleDS(Properties info) throws SQLException {
////        OracleDataSource ods = new OracleDataSource();
////        ods.setURL(DB_URL);
////        ods.setConnectionProperties(info);
////        return ods;
////    }
//
//    public static void main(String[] args) throws SQLException {
//
//
//
//
////        System.out.println(UserRolesBean.getRandomValueFromDB().getBOLUM_KODU());
////        System.out.println(UserRolesBean.getRandomValueFromDB().getERISIM_KULLANICI_KODU());
////        System.out.println(UserRolesBean.getRandomValueFromDB().getYARATILDIGI_TARIH());
////        System.out.println(UserRolesBean.getRandomValueFromDB().getROL_NUMARA());
//
//
////        try (OracleConnection connection = (OracleConnection) oracleDS(propertiesInfo()).getConnection()){
////            System.out.println(countOfSQLQuery(connection));}
////       try (OracleConnection connection = (OracleConnection) oracleDS(propertiesInfo()).getConnection()){
////          System.out.println(takeRandomCustomerNo(connection));
////       }
//
//
//
////       List<String> stringList = userRolesBean.getByColumn(connection)
////        System.out.println(userRolesBean.getByColumn(connection).getERISIM_KULLANICI_KODU());
////        System.out.println(userRolesBean.getByColumn(connection).getBOLUM_KODU());
////        System.out.println(userRolesBean.getByColumn(connection));
////
//
//
//
////        System.out.println(userRolesBean.getRandomValueFromDB(connection).getERISIM_KULLANICI_KODU());
////        System.out.println(userRolesBean.getRandomValueFromDB(connection).getROL_NUMARA());
////        System.out.println(userRolesBean.getRandomValueFromDB(connection).getBOLUM_KODU());
//
//
////
////        ResultSet resultSet1 = statement.executeQuery("select count(*) from cbs_erisim_rol where ROL_NUMARA = 1485");
////       resultSet1.next();
////            int a = Integer.parseInt(resultSet1.getString(1));
////        ResultSet resultSet = statement.executeQuery("select * from cbs_erisim_rol where ROL_NUMARA = 1485");
////        for (int i =1; i <= a; i++){
////            resultSet.next();
////        }
////        int rol_numara = resultSet.getInt("ROL_NUMARA");
////        String erisim_kullanici_kodu = resultSet.getString(2);
////        String bolum_kodu = resultSet.getString(3);
////        String yaratildigi_tarih = resultSet.getString(4);
////        System.out.println(rol_numara+" "+erisim_kullanici_kodu + " "+bolum_kodu + " "+yaratildigi_tarih);
//
//
//
////        int columns = rs.getMetaData().getColumnCount();
////        // Перебор строк с данными
////        while(rs.next()){
////            for (int i = 1; i <= columns; i++){
////                System.out.print(rs.getString(i) + "\t");
////            }
////            System.out.println();
////        }
////        System.out.println();
//
//
//
//
////        resultSet.next();
////            int rol_numara = resultSet.getInt(1);
////            String erisim_kullanici_kodu = resultSet.getString(2);
////            String bolum_kodu = resultSet.getString(3);
////            String yaratildigi_tarih = resultSet.getString(4);
////            System.out.println(rol_numara+" "+erisim_kullanici_kodu + " "+bolum_kodu + " "+yaratildigi_tarih);
//
//
//
////        System.out.println(takeRandomCustomerNo(connection));
////        delete(connection);
////
////        String b = "Marcus Belby";
////        String a = "declare\n" +
////                "    ls_name varchar2(50);\n" +
////                " begin\n" +
////                "select ID into ls_name from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = '"+b+"' and rownum <=1;\n" +
////                "delete from WEBPORTAL.CUSTOMER_ANNOUNCE_DETAIL where ANNOUNCE_ID = ls_name;\n" +
////                "delete from WEBPORTAL.CUSTOMER_ANNOUNCE  where ID = ls_name;\n" +
////                "commit;\n" +
////                "exception when others then\n" +
////                "null;\n" +
////                "end;";
////
////
////        Statement statement = connection.createStatement();
////        statement.executeQuery(a);
//
//
//
//
//    }
//
//
////-----------------------------------------------------------------------------------------------------
//
//    public static ResultSet delete (Connection connection) throws SQLException {
//        Statement statement = connection.createStatement();
//        return statement.executeQuery("delete from WEBPORTAL.CUSTOMER_ANNOUNCE_DETAIL where ANNOUNCE_ID = (select ID from WEBPORTAL.CUSTOMER_ANNOUNCE  where ANNOUNCE_SUBJECT = 'Rabastan Lestrange')");
//    }
//
//    public static int countOfSQLQuery(Connection connection) throws SQLException {
//        List<String> emailCustomers = new ArrayList<>();
//        try (Statement statement = connection.createStatement()) {
//            try (ResultSet resultSet = statement
//                    .executeQuery("select bb.musteri_no customer_no, nvl(bb.ticari_unvan, bb.isim || ' ' || bb.ikinci_isim || ' \n" +
//                            "            ' || bb.soyadi) full_name, aa.email email from cbs.cbs_musteri bb, cbs.cbs_musteri_adres\n" +
//                            "             aa where bb.musteri_tipi_kod is not null  and aa.musteri_no = bb.musteri_no and aa.email is not null order by customer_no")) {
//                while (resultSet.next())
//                    emailCustomers.add(resultSet.getString(1));
//            }
//        }
//        return emailCustomers.size();
//    }
//
//
//
//    public static String takeRandomCustomerNo(Connection connection) throws SQLException {
//        List<String> emailCustomers = new ArrayList<>();
//        Statement statement = connection.createStatement();
//        try (ResultSet resultSet = statement.executeQuery("SELECT MUSTERI_NO FROM CBS_MUSTERI")) {
//            while (resultSet.next())
//                emailCustomers.add(resultSet.getString(1));
////                while (resultSet.next())
////                    System.out.println(resultSet.getString(1));
//        }
//        int min = 0;
//        int max = emailCustomers.size();
//        int diff = max - min;
//        Random random = new Random();
//        int randomNo = random.nextInt(diff + 1) + min;
//        return emailCustomers.get(randomNo);
//    }
//
//
//    public static List<String> countOfAccount(Connection connection) throws SQLException {
//        List<String> emailCustomers = new ArrayList<>();
//        Statement statement = connection.createStatement();
//        try (ResultSet resultSet = statement.executeQuery("SELECT MUSTERI_NO FROM CBS_MUSTERI")) {
//            while (resultSet.next())
//                emailCustomers.add(resultSet.getString(1));
////                while (resultSet.next())
////                    System.out.println(resultSet.getString(1));
//        }
//
//        return emailCustomers;
//    }
//
//    public static void printEmployees(Connection connection) throws SQLException {
//        List<String> emailCustomers = new ArrayList<>();
//        try (Statement statement = connection.createStatement()) {
//            try (ResultSet resultSet = statement
//                    .executeQuery("select * from cbs_musteri_adres where email is not null")) {
//                while (resultSet.next())
//                    emailCustomers.add(resultSet.getString(1));
//                System.out.println(emailCustomers.size());
//                Assert.assertEquals(emailCustomers.get(0), "71178");
////                while (resultSet.next())
////                System.out.println(resultSet.getString(1));
//            }
//        }
//    }
//
//    public static String countOfUsersWithEmail(Connection connection) throws SQLException {
//        String res = null;
//        try (Statement statement = connection.createStatement()) {
//            try (ResultSet resultSet = statement
//                    .executeQuery("select count (*) from cbs_musteri_adres where email is not null")) {
//                while (resultSet.next())
//                    res = resultSet.getString(1);
////                    System.out.println(resultSet.getString(1));
//            }
//        }
//        return res;
//
//
//    }
//}
