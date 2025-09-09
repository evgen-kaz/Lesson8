package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    static void setupConfigAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void setupConfigEach() {
        Configuration.baseUrl = "https://www.labirint.ru/";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
