package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductSearchPage {
    private final SelenideElement
            searchString = $("#search-field"),
            buttonSearch = $("button[form='searchform']"),
            buttonPostpone = $("[data-tooltip_title='Отложить']"),
            nameFoundProduct = $(".product-card__name"),
            buttonDeferredHeader = $("[href='/cabinet/putorder/']"),
            nameDeferredProduct = $(".product-title"),
            textResultSearch = $(".index-top-title");

    private final ElementsCollection
            tabsInHeader = $$(".b-header-b-menu-wrapper");

    public ProductSearchPage openPage() {
        open("");
        return this;
    }

    public ProductSearchPage searchProduct(String nameProduct) {
        searchString.setValue(nameProduct);
        buttonSearch.click();
        return this;
    }

    public void checkResultSearchProduct(String expectedText) {
        textResultSearch.shouldHave(text(expectedText));
    }

    public ProductSearchPage addingProductInWishlist(String nameProduct) {
        nameFoundProduct.shouldHave(text(nameProduct));
        buttonPostpone.click();
        return this;
    }

    public void checkResulAddingProductInWishlist(String nameProduct) {
        buttonDeferredHeader.click();
        nameDeferredProduct.shouldHave(text(nameProduct));
    }

    public void checkingDisplaySectionsInHeader(TabsHeader tabInHeader) {
        tabsInHeader.find(text(tabInHeader.name())).shouldBe(visible);
    }


}
