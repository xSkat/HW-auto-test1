package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static testdata.TestData.*;

public class VariableValuesHWUnitFourTests extends BaseTest {

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(FIRST_NAME);
        $("#lastName").val(LAST_NAME);
        $("#userEmail").val(USER_EMAIL);
        $("#genterWrapper").$(byText(GENDER_MALE)).click();
        $("#userNumber").val(USER_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(BIRTH_MONTH);
        $(".react-datepicker__year-select").selectOption(BIRTH_YEAR);
        $("[aria-label='Choose Tuesday, " + BIRTH_MONTH + " " + BIRTH_DAY + "th, " + BIRTH_YEAR + "']").click();
        $("#subjectsInput").val(SUBJECT_INPUT).pressEnter();
        $("#hobbiesWrapper").$(byText(MY_ACTION)).click();
        $("#uploadPicture").uploadFromClasspath(UPLOAD_PICTURE);
        $("#currentAddress").val(MY_ADDRESS);
        $("#stateCity-wrapper").click();
        $(byText(MY_COUNTRY)).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $(byText(MY_CITY)).shouldBe(visible).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(FIRST_NAME + " " + LAST_NAME));
        $(".table-responsive").shouldHave(text(USER_EMAIL));
        $(".table-responsive").shouldHave(text(GENDER_MALE));
        $(".table-responsive").shouldHave(text(USER_NUMBER));
        $(".table-responsive").shouldHave(text(BIRTH_DAY + " " + BIRTH_MONTH + "," + BIRTH_YEAR));
        $(".table-responsive").shouldHave(text(SUBJECT_INPUT));
        $(".table-responsive").shouldHave(text(MY_ACTION));
        $(".table-responsive").shouldHave(text(UPLOAD_PICTURE));
        $(".table-responsive").shouldHave(text(MY_ADDRESS));
        $(".table-responsive").shouldHave(text(MY_COUNTRY + " " + MY_CITY));
    }

    @Test
    void positiveMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(FIRST_NAME);
        $("#lastName").val(LAST_NAME);
        $("#genterWrapper").$(byText(GENDER_MALE)).click();
        $("#userNumber").val(USER_NUMBER);
        $("#submit").click();

        $(".table-responsive").shouldHave(text(FIRST_NAME + " " + LAST_NAME));
        $(".table-responsive").shouldHave(text(GENDER_MALE));
        $(".table-responsive").shouldHave(text(USER_NUMBER));
    }

    @Test
    void negativeMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(FIRST_NAME);
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

        $("#firstName").val(FIRST_NAME);
        $("#lastName").val(LAST_NAME);
        $("#genterWrapper").$(byText(GENDER_MALE)).click();
        $("#userNumber").val(UNCORRECT_USER_NUNBER);
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

        $("#firstName").val(FIRST_NAME);
        $("#lastName").val(LAST_NAME);
        $("#genterWrapper").$(byText(GENDER_MALE)).click();
        $("#userNumber").val(UNCORRECT_USER_NUNBER);
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue(BORDER_COLOR, UNCORRECT_USER_NUMBER_RGB_COLOR));
    }



    //======================================TextBox
    @Test
    void textBoxFormPositiveTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userName").val(FIRST_NAME);
        $("#userEmail").val(USER_EMAIL);
        $("#currentAddress").val(CURRENT_ADDRESS);
        $("#permanentAddress").val(PERMANENT_ADDRESS);
        $("#submit").click();

        $("#output").shouldHave(text(FIRST_NAME));
        $("#output").shouldHave(text(USER_EMAIL));
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

        $(".field-error").shouldHave(cssValue(BORDER_COLOR, ERROR_RGB_COLOR));
    }
}
