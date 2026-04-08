package Tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomeWorkTests extends BaseTest {

    @Test
    void firststep() {
        open("/automation-practice-form");
        $("#firstName").val("Tony");
        $("#lastName").val("Kek");
        $("#userEmail").val("zdarova@gmail.com");
        $("#gender-radio-1").click();
        $("#userNumber").val("89823455432");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1968");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").val("history").pressEnter();;
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFromClasspath("cat.gif");
        $("#currentAddress").val("Kaiosdjkn");
        $("#stateCity-wrapper").click();
        $(byText("Haryana")).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $(byText("Panipat")).shouldBe(visible).click();
        $("#submit").click();



        $("").shouldHave(text(""));
        $("").shouldHave(text(""));
        $("").shouldHave(text(""));
        $("").shouldHave(text(""));
        $("").shouldHave(text(""));

    }
}
