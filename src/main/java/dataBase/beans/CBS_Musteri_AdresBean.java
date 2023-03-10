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
public class CBS_Musteri_AdresBean {

    String MUSTERI_NO;
    int ADRES_KOD;
    String ADRES;
    String SEMT;



    public static int getNumberOfRecords() throws SQLException {
        String query = "";
        int a = 0;
        ResultSet resultSet = JDBCOracle.query(query);
        while (resultSet.next()){
            a = Integer.parseInt(resultSet.getString(1));
        }
        return a;
    }


    public static CBS_Musteri_AdresBean getRandomRow(){
        String sqlQuery = "";
        try(ResultSet resultSet = JDBCOracle.query(sqlQuery)){
            int size = JavaFakerData.getRandomNumber(getNumberOfRecords());
            for (int i = 1; i < size; i++) {
                resultSet.next();
            }
            return new BeanProcessor().toBean(resultSet, CBS_Musteri_AdresBean.class);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }














}
