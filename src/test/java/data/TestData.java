package data;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestData {

    @BeforeEach
        void openBrowser () {
        open("https://www.zabgu.ru");
        Configuration.pageLoadStrategy = "eager";
    }


}
