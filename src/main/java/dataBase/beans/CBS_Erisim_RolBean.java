package dataBase.beans;

import dataBase.dbUtils.JDBCOracle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import mockData.JavaFakerData;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CBS_Erisim_RolBean {

    int ROL_NUMARA;
    String ERISIM_KULLANICI_KODU;
    String BOLUM_KODU;
    int YARATILDIGI_TARIH;
    String YARATAN_KULLANICI_KODU;


    public CBS_Erisim_RolBean() {
    }
    public static int getNumberOfRecords() throws SQLException {
        String query = "select count(*) from cbs_erisim_rol";
        int a = 0;
        ResultSet resultSet = JDBCOracle.query(query);
        while (resultSet.next()){
            a = Integer.parseInt(resultSet.getString(1));
        }
        return a;
    }
    public static CBS_Erisim_RolBean getRandomRow(){
        String sqlQuery = "select * from cbs_erisim_rol";
        try(ResultSet resultSet = JDBCOracle.query(sqlQuery)){
            int size = JavaFakerData.getRandomNumber(getNumberOfRecords());
            for (int i = 1; i < size; i++) {
                resultSet.next();
            }
            return new BeanProcessor().toBean(resultSet, CBS_Erisim_RolBean.class);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


//    public CBS_Erisim_RolBean getsmth (){
//        String sqlQuery = "select * from cbs_erisim_rol";
//        try (ResultSet resultSet = JDBCOracle.query(sqlQuery)){
//            while (resultSet.next()){
//                return new BeanProcessor().toBean(resultSet, CBS_Erisim_RolBean.class);
//            }
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//        return this;
//    }




//    public UserRolesBean(ResultSet resultSet) {
//
//        try {
//            new BeanProcessor().populateBean(resultSet, this);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public UserRolesBean getByColumn() {
//        String query = "select * from cbs_erisim_rol where ROL_NUMARA = 1485";
//        try (ResultSet resultSet = JDBCConnect.query(query)) {
//            if (!resultSet.next()) return null;
//            return new BeanProcessor().toBean(resultSet, UserRolesBean.class);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public static int getNumberOfRecords() throws SQLException {
//        String query = "select count(*) from cbs_erisim_rol";
//        int a = 0;
//        ResultSet resultSet = JDBCConnect.query(query);
//        while (resultSet.next())
//            a = Integer.parseInt(resultSet.getString(1));
//        return a;
//    }
//
//
//    public static UserRolesBean getRandomValueFromDB() throws SQLException {
//        String query = "select * from cbs_erisim_rol";
//        ResultSet resultSet = JDBCConnect.query(query);
//        {
//            for (int i = 1; i <= JavaFakerData.getRandomNumber(getNumberOfRecords()); i++) {
//                resultSet.next();
//            }
//            return new BeanProcessor().toBean(resultSet, UserRolesBean.class);


//    public UserRolesBean getRandomNoteFromBD(Connection connection) {
//        String query = "select * from cbs_erisim_rol where ROL_NUMARA = 1485";
//        ResultSet resultSet = SelectMethods.query(connection, query);
//
//        resultSet.next()
//    }


        }


