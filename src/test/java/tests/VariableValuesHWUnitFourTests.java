package tests;

import org.junit.jupiter.api.Test;
import testdata.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static testdata.TestData.*;

public class VariableValuesHWUnitFourTests extends BaseTest {
    private final TestData testData = new TestData();

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(testData.FIRST_NAME);
        $("#lastName").val(testData.LAST_NAME);
        $("#userEmail").val(testData.USER_EMAIL);
        $("#genterWrapper").$(byText(testData.GENDER_MALE)).click();
        $("#userNumber").val(testData.USER_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(testData.BIRTH_MONTH);
        $(".react-datepicker__year-select").selectOption(testData.BIRTH_YEAR);
        $("[aria-label='Choose Tuesday, " + testData.BIRTH_MONTH + " " + testData.BIRTH_DAY + "th, " + testData.BIRTH_YEAR + "']").click();
        $("#subjectsInput").val(testData.SUBJECT_INPUT).pressEnter();
        $("#hobbiesWrapper").$(byText(testData.MY_ACTION)).click();
        $("#uploadPicture").uploadFromClasspath(testData.UPLOAD_PICTURE);
        $("#currentAddress").val(testData.MY_ADDRESS);
        $("#stateCity-wrapper").click();
        $(byText(testData.MY_COUNTRY)).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $(byText(testData.MY_CITY)).shouldBe(visible).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(testData.FIRST_NAME + " " + testData.LAST_NAME));
        $(".table-responsive").shouldHave(text(testData.USER_EMAIL));
        $(".table-responsive").shouldHave(text(testData.GENDER_MALE));
        $(".table-responsive").shouldHave(text(testData.USER_NUMBER));
        $(".table-responsive").shouldHave(text(testData.BIRTH_DAY + " " + testData.BIRTH_MONTH + "," + testData.BIRTH_YEAR));
        $(".table-responsive").shouldHave(text(testData.SUBJECT_INPUT));
        $(".table-responsive").shouldHave(text(testData.MY_ACTION));
        $(".table-responsive").shouldHave(text(testData.UPLOAD_PICTURE));
        $(".table-responsive").shouldHave(text(testData.MY_ADDRESS));
        $(".table-responsive").shouldHave(text(testData.MY_COUNTRY + " " + testData.MY_CITY));
    }

    @Test
    void positiveMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(testData.FIRST_NAME);
        $("#lastName").val(testData.LAST_NAME);
        $("#genterWrapper").$(byText(testData.GENDER_MALE)).click();
        $("#userNumber").val(testData.USER_NUMBER);
        $("#submit").click();

        $(".table-responsive").shouldHave(text(testData.FIRST_NAME + " " + testData.LAST_NAME));
        $(".table-responsive").shouldHave(text(testData.GENDER_MALE));
        $(".table-responsive").shouldHave(text(testData.USER_NUMBER));
    }

    @Test
    void negativeMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(testData.FIRST_NAME);
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }

    @Test
    void sendUncorrectUserNumberTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(testData.FIRST_NAME);
        $("#lastName").val(testData.LAST_NAME);
        $("#genterWrapper").$(byText(testData.GENDER_MALE)).click();
        $("#userNumber").val(testData.UNCORRECT_USER_NUMBER);
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }

    @Test
    void checkErrorFieldColorTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(testData.FIRST_NAME);
        $("#lastName").val(testData.LAST_NAME);
        $("#genterWrapper").$(byText(testData.GENDER_MALE)).click();
        $("#userNumber").val(testData.UNCORRECT_USER_NUMBER);
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue(testData.BORDER_COLOR, testData.UNCORRECT_USER_NUMBER_RGB_COLOR));
    }



    //======================================TextBox
    @Test
    void textBoxFormPositiveTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userName").val(testData.FIRST_NAME);
        $("#userEmail").val(testData.USER_EMAIL);
        $("#currentAddress").val(CURRENT_ADDRESS);
        $("#permanentAddress").val(PERMANENT_ADDRESS);
        $("#submit").click();

        $("#output").shouldHave(text(testData.FIRST_NAME));
        $("#output").shouldHave(text(testData.USER_EMAIL));
        $("#output").shouldHave(text(CURRENT_ADDRESS));
        $("#output").shouldHave(text(PERMANENT_ADDRESS));
    }

    @Test
    void textBoxErrorColorTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userEmail").val(UNCORRECT_USER_EMAIL);
        $("#submit").click();

        $(".field-error").shouldHave(cssValue(testData.BORDER_COLOR, testData.ERROR_RGB_COLOR));
    }
}
