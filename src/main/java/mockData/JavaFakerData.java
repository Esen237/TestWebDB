package mockData;

import com.github.javafaker.Faker;

public class JavaFakerData {

    static Faker faker = new Faker();

    public String getHarryPotterName(){
       return faker.harryPotter().character();
    }

    public String getLOLChampion(){
        return faker.leagueOfLegends().champion();
    }

    public static int getRandomNumber(int range){
        return faker.number().numberBetween(1,range);
    }



}
