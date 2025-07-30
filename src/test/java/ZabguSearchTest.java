import data.TestData;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ZabguSearchTest extends TestData {

    @CsvSource (value = {
            "Абитуриентам, ЗабГУ дарит абитуриентам подарки за участие в конкурсе",
            "Учащимся, Краевая компьютерная школа"
    })
    @ParameterizedTest(name = "Выполнение поиска c запросом {0} сайте https://www.zabgu.ru должно найти результат {1}")
    @Tag("REGRESS")
    void searchGiftsForApplicants (String searchData, String searchResult) {
        $("[name='query']").setValue(searchData).pressEnter();
        $("#tabs").shouldHave(text(searchResult));
        $$(".ntitle").findBy(text(searchResult)).click();
        $("#full_text").shouldHave(text(searchResult));
    }


    @CsvFileSource (resources = "/Data.csv")
    @ParameterizedTest (name = "Выполнение поиска c запросом {0} сайте https://www.zabgu.ru должно найти результат {1}")
    @Tags({
            @Tag("SMOKE"),
            @Tag("REGRESS")
    })
    void searchGiftsForApplicationWithFile (String data, String result) {
        $("[name='query']").setValue(data).pressEnter();
        $("#tabs").shouldHave(text(result));
        $$(".ntitle").findBy(text(result)).click();
        $("#full_text").shouldHave(text(result));
    }

}
