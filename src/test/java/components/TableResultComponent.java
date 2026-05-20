package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    private final SelenideElement resultTableComp = $(".table-responsive");

    public void shouldContain(String... expectedTexts) {
        for (String expectedText : expectedTexts) {
            resultTableComp.shouldHave(text(expectedText));
        }
    }

    public void shouldNotBeVisible() {
        resultTableComp.shouldNotBe(visible);
    }
}
