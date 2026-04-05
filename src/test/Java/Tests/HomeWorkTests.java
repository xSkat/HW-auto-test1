package Tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTests {

    @Test
    void firststep() {
        open("https://demoqa.com/automation-practice-form");
        $("").val("");
        $("").val("");
        $("").val("");
        $("").val("");
        $("").val("");
        $("").val("");
        $("").val("");
        $("").val("");
        $("").click();

        $("").shouldHave(text(""));
        $("").shouldHave(text(""));
        $("").shouldHave(text(""));
        $("").shouldHave(text(""));
        $("").shouldHave(text(""));

    }
}
