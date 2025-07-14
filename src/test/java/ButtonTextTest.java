import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ButtonTextTest extends TestData {

    @Test
    @DisplayName("Проверка текста на кнопке обратной связи")
    void buttonShouldHaveCorrectText (){
        $(".info_text").shouldHave(text("Обратная связь"));
    }

}
