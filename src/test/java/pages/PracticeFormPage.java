package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultTable = $(".table-responsive");



    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        removeBanners();
        return this;
    }

    private void removeBanners() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }

    public PracticeFormPage fillFirstName(String value) {
        firstName.val(value);
        return this;
    }

    public PracticeFormPage fillLastName(String value) {
        lastName.val(value);
        return this;
    }

    public PracticeFormPage fillEmail(String value) {
        userEmail.val(value);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage fillPhone(String value) {
        userNumber.val(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String month, String year, String day) {
        dateOfBirthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        String ariaLabel = "Choose Tuesday, " + month + " " + day + "th, " + year;
        $("[aria-label='" + ariaLabel + "']").click();
        return this;
    }

    public PracticeFormPage fillSubject(String subject) {
        subjectsInput.val(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        $(hobbiesWrapper).$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage fillCurrentAddress(String address) {
        currentAddress.val(address);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        stateCityWrapper.click();
        $(byText(state)).shouldBe(visible).click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        $("#react-select-4-input").click();
        $(byText(city)).shouldBe(visible).click();
        return this;
    }

    public PracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    public void checkResult(String... expectedTexts) {
        for (var text : expectedTexts) {
            resultTable.shouldHave(text(text));
        }
    }

    public void checkResultTableNotVisible() {
        resultTable.shouldNotBe(visible);
    }

    public void checkPhoneFieldHasErrorColor(String color) {
        userNumber.shouldHave(cssValue("border-color", color));
    }
}