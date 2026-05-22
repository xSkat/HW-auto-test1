package utils;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RandomTestDataUtils {

    private static final Faker faker = new Faker(new Locale("en"));

    public static final Map<String, List<String>> STATE_CITIES = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Meerut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaisalmer")
    );


    public static String getRandomCity(String MY_COUNTRY) {
        List<String> cities = STATE_CITIES.get(MY_COUNTRY);
        if (cities == null || cities.isEmpty()) {
            return MY_COUNTRY;
        }
        return cities.get(faker.random().nextInt(cities.size()));
    }


}



