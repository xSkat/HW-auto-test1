package Tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class homeWorkTests {

    @Test
    void firststep() {
        open("https://demoqa.com/automation-practice-form");
    }
}
