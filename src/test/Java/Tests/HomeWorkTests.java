package Tests;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomeWorkTests extends BaseTest {

    @Test
    void FullEditTest() {
        open("/automation-practice-form");
        $("#firstName").val("Tony");
        $("#lastName").val("Kek");
        $("#userEmail").val("zdarova@gmail.com");
        $("#gender-radio-1").click();
        $("#userNumber").val("8982345543");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1968");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").val("history").pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFromClasspath("cat.gif");
        $("#currentAddress").val("Kaiosdjkn");
        $("#stateCity-wrapper").click();
        $(byText("Haryana")).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $(byText("Panipat")).shouldBe(visible).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Tony Kek"));
        $(".table-responsive").shouldHave(text("zdarova@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8982345543"));
        $(".table-responsive").shouldHave(text("14 May,1968"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("cat.gif"));
        $(".table-responsive").shouldHave(text("Kaiosdjkn"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));

    }


    @Test
            void minimalPositivTest() {
        open("/automation-practice-form");
        $("#firstName").val("Tony");
        $("#lastName").val("Kek");
        $("#gender-radio-1").click();
        $("#userNumber").val("8982345543");
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Tony Kek"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8982345543"));

    }

    // Заполнить только имя
    @Test
    void MinimalNegativeTest() {
        open("/automation-practice-form");
        $("#firstName").val("Tony");
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }


    // В поле номера вместо цифр буквы
    @Test
    void MinimalNegTest1() {
        open("/automation-practice-form");
        $("#firstName").val("Tony");
        $("#lastName").val("Kek");
        $("#gender-radio-1").click();
        $("#userNumber").val("sadasd");
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }


    // В поле номера вместо цифр буквы (цвет обводки)
    @Test
            void MinimalNegTest2() {
        open("/automation-practice-form");
        $("#firstName").val("Tony");
        $("#lastName").val("Kek");
        $("#gender-radio-1").click();
        $("#userNumber").val("sadasd");
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }



    //======================================TextBox
    // Тесты на простую форму
    // Positive
    @Test
    void ezForm() {
        open("/text-box");
        $("#userName").val("Tony");
        $("#userEmail").val("zdarova@gmail.com");
        $("#currentAddress").val("Gorod728");
        $("#permanentAddress").val("Bez asdadssad11");
        $("#submit").click();

        $("#output").shouldHave(text("Tony"));
        $("#output").shouldHave(text("zdarova@gmail.com"));
        $("#output").shouldHave(text("Gorod728"));
        $("#output").shouldHave(text("Bez asdadssad11"));

    }


    // Цвет границы при негативном кейсе
    @Test
    void negForm() {
        open("/text-box");
        $("#userEmail").val("1");
        $("#submit").click();

        $(".field-error").shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));

    }


}
