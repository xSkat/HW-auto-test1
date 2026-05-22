package testdata;


import com.github.javafaker.Faker;

import static utils.RandomTestDataUtils.getRandomCity;


public class TestData {
    static Faker faker = new Faker();

    //====================================registrationFormTest
    public static final String FIRST_NAME = faker.name().firstName();
    public static final String LAST_NAME =  faker.name().lastName();
    public static final String USER_EMAIL = faker.internet().emailAddress();
    public static final String USER_NUMBER = faker.numerify("9#########");
    public static final String BIRTH_MONTH = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public static final String BIRTH_YEAR = String.valueOf(faker.number().numberBetween(1960, 2026));
    public static final String MY_ADDRESS = faker.address().fullAddress();
    public static final String UPLOAD_PICTURE = "cat.gif";
    public static final String SUBJECT_INPUT = String.valueOf(faker.options().option("Chemistry", "Math", "History", "English", "Accounting", "Art", "Social Studies", "Computer Science", "Commerce", "Economics", "Biology", "Hindi", "Physics", "Civics"));
    public static final String MY_ACTION = faker.options().option("Sports", "Reading", "Music");
    public static final String GENDER_MALE = faker.options().option("Male", "Female", "Other");
    public static final String BIRTH_DAY = String.valueOf(faker.number().numberBetween(1, 28));
    public static final String MY_COUNTRY = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static final String MY_CITY = getRandomCity(MY_COUNTRY);
    public static final String UNCORRECT_USER_NUMBER = "sadasd";
    public static final String BORDER_COLOR= "border-color";
    public static final String ERROR_RGB_COLOR= "rgb(255, 0, 0)";
    public static final String UNCORRECT_USER_NUMBER_RGB_COLOR= "rgb(220, 53, 69)";



    //======================================TextBox
    public static final String PERMANENT_ADDRESS = "Bez asdadssad11";
    public static final String CURRENT_ADDRESS = "Gorod728";
    public static final String UNCORRECT_USER_EMAIL = "1";



}
