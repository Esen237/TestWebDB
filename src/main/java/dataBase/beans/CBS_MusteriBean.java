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
public class CBS_MusteriBean {

    String MUSTERI_NO;

    public CBS_MusteriBean(){

    }
    public static int getNumberOfRecords() throws SQLException {
        String query = "select count(*) from cbs_musteri";
        int a = 0;
        ResultSet resultSet = JDBCOracle.query(query);
        while (resultSet.next()){
            a = Integer.parseInt(resultSet.getString(1));
        }
        return a;
    }


    public static CBS_MusteriBean getRandomRow(){
        String sqlQuery = "select * from cbs_musteri";
        try(ResultSet resultSet = JDBCOracle.query(sqlQuery)){
            int size = JavaFakerData.getRandomNumber(getNumberOfRecords());
            for (int i = 1; i < size; i++) {
                resultSet.next();
            }
            return new BeanProcessor().toBean(resultSet, CBS_MusteriBean.class);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }






}
