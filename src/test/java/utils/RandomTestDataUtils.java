package utils;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RandomTestDataUtils {

    private final Faker faker = new Faker(new Locale("en"));

    public static final Map<String, List<String>> STATE_CITIES = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Meerut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaisalmer")
    );

    public String getRandomCity(String  country) {
        List<String> cities = STATE_CITIES.get( country);
        if (cities == null || cities.isEmpty()) {
            return  country;
        }
        return cities.get(faker.random().nextInt(cities.size()));
    }
}




