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

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmail);
        $("#gender-radio-1").click();
        $("#userNumber").val(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").val(subjectsInput).pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").val(Address);
        $("#stateCity-wrapper").click();
        $(byText(country)).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $(byText(city)).shouldBe(visible).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(sex));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text(subjectsInput));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text(uploadPicture));
        $(".table-responsive").shouldHave(text(Address));
        $(".table-responsive").shouldHave(text(country + " " + city));
    }

    @Test
    void positiveMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").val(userNumber);
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(sex));
        $(".table-responsive").shouldHave(text(userNumber));
    }

    @Test
    void negativeMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(firstName);
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

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").val("sadasd");
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

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").val("sadasd");
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


    //======================================TextBox
    @Test
    void textBoxFormPositiveTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userName").val(firstName);
        $("#userEmail").val(userEmail);
        $("#currentAddress").val(currentAddress);
        $("#permanentAddress").val(permanentAddress);
        $("#submit").click();

        $("#output").shouldHave(text(firstName));
        $("#output").shouldHave(text(userEmail));
        $("#output").shouldHave(text(currentAddress));
        $("#output").shouldHave(text(permanentAddress));
    }

    @Test
    void textBoxErrorColorTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userEmail").val("1");
        $("#submit").click();

        $(".field-error").shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
    }
}
