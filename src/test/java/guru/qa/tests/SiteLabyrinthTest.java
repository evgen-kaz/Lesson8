package guru.qa.tests;

import guru.qa.pages.ProductSearchPage;
import guru.qa.pages.TabsHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SiteLabyrinthTest extends TestBase {
    ProductSearchPage productSearchPage = new ProductSearchPage();

    @CsvSource(value = {
            "Властелин колец | Все, что мы нашли в Лабиринте по запросу «Властелин колец»",
            "Гарри Поттер | Все, что мы нашли в Лабиринте по запросу «Гарри Поттер»",
            "Сумерки | Все, что мы нашли в Лабиринте по запросу «Сумерки»",
    }, delimiter = '|')
    @ParameterizedTest(name = "Для поискогового запроса по названию книги - {0} - должен быть результат - {1}")
    @Tag("CRITICAL")
    void successfulSearchResultByNameBookTest(String nameProduct, String expectedText) {
        productSearchPage.openPage()
                .searchProduct(nameProduct)
                .checkResultSearchProduct(expectedText);
    }

    @ValueSource(strings = {
            "Java. Полное руководство", "Эффективное тестирование программного обеспечения"
    })
    @ParameterizedTest()
    @Tag("CRITICAL")
    @DisplayName("Успешное добавление товаров в 'Отложено'")
    void successfulStorageOfGoodsTest(String nameProduct) {
        productSearchPage.openPage()
                .searchProduct(nameProduct)
                .addingProductInWishlist(nameProduct)
                .checkResulAddingProductInWishlist(nameProduct);
    }

    @CsvFileSource(resources = "/test_data/successfulAddingProductInBasketTest.csv")
    @ParameterizedTest
    @Tag("NORMAL")
    @DisplayName("Успешный поиск товаров по авторам")
    void successfulSearchResultByAuthorTest(String author, String expectedText) {
        productSearchPage.openPage()
                .searchProduct(author)
                .checkResultSearchProduct(expectedText);
    }

    @EnumSource(TabsHeader.class)
    @ParameterizedTest
    @DisplayName("Табы отображаются в хедере")
    void sectionsOfTheSiteDisplayed(TabsHeader tabInHeader) {
        productSearchPage.openPage()
                .checkingDisplaySectionsInHeader(tabInHeader);
    }
}
