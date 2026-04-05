package Tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTests extends BaseTest {

    @Test
    void firststep() {
        open("/automation-practice-form");
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
