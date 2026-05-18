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

        $("#firstName").val(first_Name);
        $("#lastName").val(last_Name);
        $("#userEmail").val(user_Email);
        $("#gender-radio-1").click();
        $("#userNumber").val(user_Number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").val(subjects_Input).pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFromClasspath(upload_Picture);
        $("#currentAddress").val(ADDRESS);
        $("#stateCity-wrapper").click();
        $(byText(country)).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $(byText(city)).shouldBe(visible).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(first_Name + " " + last_Name));
        $(".table-responsive").shouldHave(text(user_Email));
        $(".table-responsive").shouldHave(text(sex));
        $(".table-responsive").shouldHave(text(user_Number));
        $(".table-responsive").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text(subjects_Input));
        $(".table-responsive").shouldHave(text(action));
        $(".table-responsive").shouldHave(text(upload_Picture));
        $(".table-responsive").shouldHave(text(ADDRESS));
        $(".table-responsive").shouldHave(text(country + " " + city));
    }

    @Test
    void positiveMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(first_Name);
        $("#lastName").val(last_Name);
        $("#gender-radio-1").click();
        $("#userNumber").val(user_Number);
        $("#submit").click();

        $(".table-responsive").shouldHave(text(first_Name + " " + last_Name));
        $(".table-responsive").shouldHave(text(sex));
        $(".table-responsive").shouldHave(text(user_Number));
    }

    @Test
    void negativeMinimalTest() {
        open("/automation-practice-form");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#firstName").val(first_Name);
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

        $("#firstName").val(first_Name);
        $("#lastName").val(last_Name);
        $("#gender-radio-1").click();
        $("#userNumber").val(Uncorrect_User_Number);
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

        $("#firstName").val(first_Name);
        $("#lastName").val(last_Name);
        $("#gender-radio-1").click();
        $("#userNumber").val(Uncorrect_User_Number);
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue(Border_Color, Uncorrect_User_Number_Rgb_Color));
    }



    //======================================TextBox
    @Test
    void textBoxFormPositiveTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userName").val(first_Name);
        $("#userEmail").val(user_Email);
        $("#currentAddress").val(current_Address);
        $("#permanentAddress").val(permanent_Address);
        $("#submit").click();

        $("#output").shouldHave(text(first_Name));
        $("#output").shouldHave(text(user_Email));
        $("#output").shouldHave(text(current_Address));
        $("#output").shouldHave(text(permanent_Address));
    }

    @Test
    void textBoxErrorColorTest() {
        open("/text-box");

        executeJavaScript("""
        document.getElementById('fixedban')?.remove();
        document.querySelector('footer')?.remove();
        """);

        $("#userEmail").val(Uncorrect_User_Email);
        $("#submit").click();

        $(".field-error").shouldHave(cssValue(Border_Color, Error_Rgb_Color));
    }
}
