package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.BORDER_COLOR;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement permanentAddress = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement output = $("#output");
    private final SelenideElement emailErrorField = $(".field-error");

    public TextBoxPage openPage() {
        open("/text-box");
        removeBanners();
        return this;
    }

    private void removeBanners() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }

    public TextBoxPage fillUserName(String name) {
        userName.val(name);
        return this;
    }

    public TextBoxPage fillEmail(String email) {
        userEmail.val(email);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String address) {
        currentAddress.val(address);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String address) {
        permanentAddress.val(address);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public void checkOutputContains(String... expectedTexts) {
        for (var expectedText : expectedTexts) {
            output.shouldHave(text(expectedText));
        }
    }

    public void checkEmailFieldHasErrorColor(String color) {
        emailErrorField.shouldHave(cssValue(BORDER_COLOR, color));
    }
}
