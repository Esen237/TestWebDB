package dataBase.beans;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.BeanProcessor;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailCustomersBean {

    private int countOfCustomersEmail;




    public EmailCustomersBean(){
    }



    public EmailCustomersBean(ResultSet resultSet) throws SQLException {
        new BeanProcessor().populateBean(resultSet, this);
    }


//   public EmailCustomersBean getByColumn(String column, String value){
//
//   }


}
