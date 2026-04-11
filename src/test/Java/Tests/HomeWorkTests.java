package Tests;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomeWorkTests extends BaseTest {

    @Test
    void firstep() {
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
        ;
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
        $("#firstName").val("Tony");
        $("#lastName").val("Kek");
        $("#gender-radio-1").click();
        $("#userNumber").val("8982345543");
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Tony Kek"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8982345543"));



    }
}
