package mockData;

import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class JavaFakerData {

    static Faker faker = new Faker();

    public String getHarryPotterName(){
       return faker.harryPotter().character();
    }

    public String getAnimalName(){
        return faker.animal().name();
    }

    public static int getRandomNumber(int range){
        return faker.number().numberBetween(0,range);
    }

    public static String getLocalDate() throws ParseException {
        String date1 = String.valueOf(LocalDate.now());
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dt.parse(date1);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        return dt1.format(date);
    }


}
