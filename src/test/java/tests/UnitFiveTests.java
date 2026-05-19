package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.TextBoxPage;
import static testdata.TestData.*;

public class UnitFiveTests extends BaseTest {

    private final PracticeFormPage practiceForm = new PracticeFormPage();
    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void registrationFormTest() {
        practiceForm.openPage()
                .fillFirstName(FIRST_NAME)
                .fillLastName(LAST_NAME)
                .fillEmail(USER_EMAIL)
                .selectGender(GENDER_MALE)
                .fillPhone(USER_NUMBER)
                .setBirthDate(BIRTH_MONTH, BIRTH_YEAR, BIRTH_DAY)
                .fillSubject(SUBJECT_INPUT)
                .selectHobby(MY_ACTION)
                .uploadPicture(UPLOAD_PICTURE)
                .fillCurrentAddress(MY_ADDRESS)
                .selectState(MY_COUNTRY)
                .selectCity(MY_CITY)
                .submit()
                .checkResult(
                        FIRST_NAME + " " + LAST_NAME,
                        USER_EMAIL,
                        GENDER_MALE,
                        USER_NUMBER,
                        BIRTH_DAY + " " + BIRTH_MONTH + "," + BIRTH_YEAR,
                        SUBJECT_INPUT,
                        MY_ACTION,
                        UPLOAD_PICTURE,
                        MY_ADDRESS,
                        MY_COUNTRY + " " + MY_CITY
                );
    }

    @Test
    void positiveMinimalTest() {
        practiceForm.openPage()
                .fillFirstName(FIRST_NAME)
                .fillLastName(LAST_NAME)
                .selectGender(GENDER_MALE)
                .fillPhone(USER_NUMBER)
                .submit()
                .checkResult(FIRST_NAME + " " + LAST_NAME, GENDER_MALE, USER_NUMBER);
    }

    @Test
    void negativeMinimalTest() {
        practiceForm.openPage()
                .fillFirstName(FIRST_NAME)
                .submit()
                .checkResultTableNotVisible();
    }

    @Test
    void sendUncorrectUserNumberTest() {
        practiceForm.openPage()
                .fillFirstName(FIRST_NAME)
                .fillLastName(LAST_NAME)
                .selectGender(GENDER_MALE)
                .fillPhone(UNCORRECT_USER_NUMBER)
                .submit()
                .checkResultTableNotVisible();
    }

    @Test
    void checkErrorFieldColorTest() {
        practiceForm.openPage()
                .fillFirstName(FIRST_NAME)
                .fillLastName(LAST_NAME)
                .selectGender(GENDER_MALE)
                .fillPhone(UNCORRECT_USER_NUMBER)
                .submit()
                .checkPhoneFieldHasErrorColor(BORDER_COLOR, UNCORRECT_USER_NUMBER_RGB_COLOR);
    }

    //====================================== TextBox ======================================

    @Test
    void textBoxFormPositiveTest() {
        textBoxPage.openPage()
                .fillUserName(FIRST_NAME)
                .fillEmail(USER_EMAIL)
                .fillCurrentAddress(CURRENT_ADDRESS)
                .fillPermanentAddress(PERMANENT_ADDRESS)
                .submit()
                .checkOutputContains(FIRST_NAME, USER_EMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS);
    }

    @Test
    void textBoxErrorColorTest() {
        textBoxPage.openPage()
                .fillEmail(UNCORRECT_USER_EMAIL)
                .submit()
                .checkEmailFieldHasErrorColor(BORDER_COLOR, ERROR_RGB_COLOR);
    }
}
