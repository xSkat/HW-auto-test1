package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.TextBoxPage;
import testdata.TestData;

import static testdata.TestData.*;

public class UnitFiveTests extends BaseTest {

    private final PracticeFormPage practiceForm = new PracticeFormPage();
    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final TestData testData = new TestData();

    @Test
   public void registrationFormTest() {
        practiceForm.openPage()
                .fillFirstName(testData.FIRST_NAME)
                .fillLastName(testData.LAST_NAME)
                .fillEmail(testData.USER_EMAIL)
                .selectGender(testData.GENDER_MALE)
                .fillPhone(testData.USER_NUMBER)
                .setBirthDate(testData.BIRTH_MONTH, testData.BIRTH_YEAR, testData.BIRTH_DAY)
                .fillSubject(testData.SUBJECT_INPUT)
                .selectHobby(testData.MY_ACTION)
                .uploadPicture(testData.UPLOAD_PICTURE)
                .fillCurrentAddress(testData.MY_ADDRESS)
                .selectState(testData.MY_COUNTRY)
                .selectCity(testData.MY_CITY)
                .submit()
                .checkResult(
                        testData.FIRST_NAME + " " + testData.LAST_NAME,
                        testData.USER_EMAIL,
                        testData.GENDER_MALE,
                        testData.USER_NUMBER,
                        testData.BIRTH_DAY + " " + testData.BIRTH_MONTH + "," + testData.BIRTH_YEAR,
                        testData.SUBJECT_INPUT,
                        testData.MY_ACTION,
                        testData.UPLOAD_PICTURE,
                        testData.MY_ADDRESS,
                        testData.MY_COUNTRY + " " + testData.MY_CITY
                );
    }

    @Test
    void positiveMinimalTest() {
        practiceForm.openPage()
                .fillFirstName(testData.FIRST_NAME)
                .fillLastName(testData.LAST_NAME)
                .selectGender(testData.GENDER_MALE)
                .fillPhone(testData.USER_NUMBER)
                .submit()
                .checkResult(
                        testData.FIRST_NAME + " " + testData.LAST_NAME,
                        testData.GENDER_MALE,
                        testData.USER_NUMBER
                );
    }

    @Test
    void negativeMinimalTest() {
        practiceForm.openPage()
                .fillFirstName(testData.FIRST_NAME)
                .submit()
                .checkResultTableNotVisible();
    }

    @Test
    void sendUncorrectUserNumberTest() {
        practiceForm.openPage()
                .fillFirstName(testData.FIRST_NAME)
                .fillLastName(testData.LAST_NAME)
                .selectGender(testData.GENDER_MALE)
                .fillPhone(testData.UNCORRECT_USER_NUMBER)
                .submit()
                .checkResultTableNotVisible();
    }

    @Test
    void checkErrorFieldColorTest() {
        practiceForm.openPage()
                .fillFirstName(testData.FIRST_NAME)
                .fillLastName(testData.LAST_NAME)
                .selectGender(testData.GENDER_MALE)
                .fillPhone(testData.UNCORRECT_USER_NUMBER)
                .submit()
                .checkPhoneFieldHasErrorColor(
                        testData.BORDER_COLOR,
                        testData.UNCORRECT_USER_NUMBER_RGB_COLOR
                );
    }

    @Test
    void textBoxFormPositiveTest() {
        textBoxPage.openPage()
                .fillUserName(testData.FIRST_NAME)
                .fillEmail(testData.USER_EMAIL)
                .fillCurrentAddress(CURRENT_ADDRESS)
                .fillPermanentAddress(PERMANENT_ADDRESS)
                .submit()
                .checkOutputContains(
                        testData.FIRST_NAME,
                        testData.USER_EMAIL,
                        CURRENT_ADDRESS,
                        PERMANENT_ADDRESS
                );
    }

    @Test
    void textBoxErrorColorTest() {
        textBoxPage.openPage()
                .fillEmail(UNCORRECT_USER_EMAIL)
                .submit()
                .checkEmailFieldHasErrorColor(
                        testData.BORDER_COLOR,
                        testData.ERROR_RGB_COLOR
                );
    }
}
