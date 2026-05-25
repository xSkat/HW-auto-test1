package testdata;


import com.github.javafaker.Faker;

import utils.RandomTestDataUtils;


public class TestData {
    public final Faker faker = new Faker();
    public final RandomTestDataUtils randomTestDataUtils = new RandomTestDataUtils();

    //====================================registrationFormTest
    public final String FIRST_NAME;
    public final String LAST_NAME;
    public final String USER_EMAIL;
    public final String USER_NUMBER;
    public final String BIRTH_MONTH;
    public final String BIRTH_YEAR;
    public final String MY_ADDRESS;
    public final String UPLOAD_PICTURE = "cat.gif";
    public final String SUBJECT_INPUT;
    public final String MY_ACTION;
    public final String GENDER_MALE;
    public final String BIRTH_DAY;
    public final String MY_COUNTRY;
    public final String MY_CITY;
    public final String UNCORRECT_USER_NUMBER = "sadasd";
    public final String BORDER_COLOR = "border-color";
    public final String ERROR_RGB_COLOR = "rgb(255, 0, 0)";
    public final String UNCORRECT_USER_NUMBER_RGB_COLOR = "rgb(220, 53, 69)";

    public static final String PERMANENT_ADDRESS = "Bez asdadssad11";
    public static final String CURRENT_ADDRESS = "Gorod728";
    public static final String UNCORRECT_USER_EMAIL = "1";

    public TestData() {
        this.FIRST_NAME = faker.name().firstName();
        this.LAST_NAME = faker.name().lastName();
        this.USER_EMAIL = faker.internet().emailAddress();
        this.USER_NUMBER = faker.numerify("9#########");
        this.BIRTH_MONTH = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        this.BIRTH_YEAR = String.valueOf(faker.number().numberBetween(1960, 2026));
        this.MY_ADDRESS = faker.address().fullAddress();
        this.SUBJECT_INPUT = faker.options().option(
                "Chemistry", "Math", "History", "English", "Accounting", "Art",
                "Social Studies", "Computer Science", "Commerce", "Economics",
                "Biology", "Hindi", "Physics", "Civics"
        );
        this.MY_ACTION = faker.options().option("Sports", "Reading", "Music");
        this.GENDER_MALE = faker.options().option("Male", "Female", "Other");
        this.BIRTH_DAY = String.valueOf(faker.number().numberBetween(1, 28));
        this.MY_COUNTRY = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        this.MY_CITY = randomTestDataUtils.getRandomCity(MY_COUNTRY);
    }
}


    //======================================TextBox
    public static final String PERMANENT_ADDRESS = "Bez asdadssad11";
    public static final String CURRENT_ADDRESS = "Gorod728";
    public static final String UNCORRECT_USER_EMAIL = "1";



}