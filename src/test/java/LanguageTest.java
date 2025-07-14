import data.Language;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LanguageTest {
    @Tag("REGRESS")
    @ParameterizedTest (name = "Проверка корректного отображения EN текста")
    @EnumSource(Language.class)
    void zabguShouldDisplayCorrectText (Language language) {
        open ("https://zabgu.ru/php/page.php?query=about_us");
        $$("#page_content_wrapper img").get(4).click();
        $$("#page_content_wrapper img").get(1).click();
        $("#page_content_wrapper").shouldHave(text(language.description));
    }
}
