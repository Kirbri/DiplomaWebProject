package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final SelenideElement breadcrumbs = $("[data-marker='breadcrumbs']"),
            pageTitleText = $("[data-marker='page-title/text']"),
            pageTitleCount = $("[data-marker='page-title/count']"),
            noResultsTitle = $("[class^=no-results-title]"),
            moreExpandButton = $("[data-marker='rubricator/more-expand-button']"),
            subscribeSearchSave = $("[data-marker='subscribe-search/save']");

    @Step("Проверить правильный выбор категории")
    public CatalogPage checkBreadcrumbsText(String... value) {
        for (String s : value) {
            breadcrumbs.shouldBe(Condition.innerText(s));
        }
        return this;
    }

    @Step("Проверить текстовый заголовок '{keyWord}' по запросу")
    public CatalogPage checkPageTitleTextOnRequest(String keyWord) {
        pageTitleText.shouldBe(text("Объявления по запросу «" + keyWord + "»"));
        return this;
    }

    @Step("Проверить текстовый заголовок '{keyWord}' по категории")
    public CatalogPage checkPageTitleTextByCategory(String keyWord) {
        pageTitleText.shouldHave(text(keyWord));
        return this;
    }

    @Step("Проверить, что нет результатов, удовлетворяющих условиям поиска")
    public CatalogPage checkNotVisiblePageTitleCount() {
        pageTitleCount.shouldNotBe(visible);
        return this;
    }

    @Step("Проверить, что есть результаты, удовлетворяющие условиям поиска")
    public CatalogPage checkVisiblePageTitleCount() {
        pageTitleCount.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что не найдено объявлений, удовлетворяющих условиям поиска")
    public CatalogPage checkNoResultsTitle(String value) {
        noResultsTitle.shouldHave(text(value));
        return this;
    }

    @Step("Показать все скрытые категории")
    public CatalogPage clickMoreExpandButton() {
        moreExpandButton.click();
        return this;
    }

    @Step("Выбрать подкатегорию")
    public CatalogPage chooseSubcategory(int value) {
        $("[data-marker='category[" + value + "]']").click();
        return this;
    }

    @Step("Нажать 'Сохранить поиск'")
    public CatalogPage pressSaveSearch() {
        subscribeSearchSave.click();
        return this;
    }
}