package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.labirint.ru/";
        Configuration.pageLoadStrategy = "eager";
    }
}
