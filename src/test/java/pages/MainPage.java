package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement headerNavigation = $("[data-marker='header-navigation'] a"),
            acceptCookies = $("[class^=styles-module-actions]"),
            locationTooltipChange = $("[data-marker='location/tooltip-change']"),
            locationClearButton = $("[data-marker='popup-location/region/clearButton']"),
            locationSearchInput = $("[data-marker='popup-location/region/search-input']"),
            locationSuggest = $("[data-marker='popup-location/suggest-0']"),
            locationSaveButton = $("[data-marker='popup-location/save-button']"),
            currentLocation = $("[data-marker='search-form/change-location']"),
            expandCategoriesWindow = $("[data-marker='more-popup']"),
            allCategories = $("[data-marker='top-rubricator/all-categories']"),
            moreCategories = $("[data-marker='top-rubricator/more-button']"),
            searchBar = $("[data-marker='search-form/suggest/input']"),
            searchListItem = $("[data-marker='suggest/list/item']"),
            headerFavorites = $("[data-marker='header/favorites']"),
            allFavorites = $("[data-marker='side-block/favorite-block'] [class^=buyer-location]"),
            linkFirstAnnouncement = $("[data-marker='bx-recommendations-block-item'] [data-marker='title']"),
            loginButton = $("[data-marker='header/login-button']"),
            animationOriginWindow = $("[class^=styles-module-animation-origin-bottom]"),
            animationOriginButton = $("[class^=styles-module-animation-origin-bottom] [type='button']");

    private final ElementsCollection favoriteAnnouncement = $$("[data-marker='favorite']"),
            titlesOfAnnouncement = $$("[itemprop='name']");

    public String titleFirstAnnouncement;

    @Step("Открыть главную страницу avito.ru")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Проверить загрузку элемента header на главной странице")
    public MainPage checkLoadingHeaderNavigation(String value) {
        headerNavigation.shouldHave(attribute("title", value));
        return this;
    }

    @Step("Нажать 'Хорошо' на информационном окне с политикой о куках")
    public MainPage closeCookieInformation() {
        acceptCookies.click();
        return this;
    }

    @Step("Нажать 'Наконец-то' на информационном окне")
    public MainPage closeModuleAnimation() {
        if (animationOriginWindow.exists()) {
            animationOriginButton.click();
        }
        return this;
    }

    @Step("Нажать 'Изменить' на информации о локации")
    public MainPage pressChangeLocation() {
        locationTooltipChange.click();
        return this;
    }

    @Step("Очистить поле с определённой локацией")
    public MainPage clearFieldLocation() {
        locationClearButton.click();
        return this;
    }

    @Step("Ввести локацию - {value}")
    public MainPage enterSearchLocation(String value) {
        locationSearchInput.sendKeys(value);
        return this;
    }

    @Step("Проверить введённую локацию и выбрать её")
    public MainPage checkAndChooseEnteredLocation(String value) {
        locationSuggest.shouldHave(text(value)).click();
        return this;
    }

    @Step("Выбрать категорию из выпадающего списка")
    public MainPage selectLocationFromDropDownList() {
        locationSaveButton.click();
        return this;
    }

    @Step("Проверить название текущей локации")
    public MainPage checkCurrentLocation(String value) {
        currentLocation.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на кнопку 'Все категории' на главной странице")
    public MainPage clickAllCategories() {
        while (!expandCategoriesWindow.exists()) {
            allCategories.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        }
        return this;
    }

    @Step("Нажать на выбранную корневую категорию")
    public MainPage clickRootCategory(int value) {
        $("[data-marker='top-rubricator/root-category-" + value + "']").hover();
        return this;
    }

    @Step("Нажать на кнопку, раскрывающую все категории животных")
    public MainPage clickMoreCategories() {
        moreCategories.click();
        return this;
    }

    @Step("Выбрать под категорию")
    public MainPage chooseSubCategory(int categoryNumber) {
        $("[data-marker='top-rubricator/sub-category-" + categoryNumber + "']").scrollTo().click();
        return this;
    }

    @Step("Открыть рекомендованный выпадающий список категорий в строке поиска")
    public MainPage openDropDownListOfSuggestionsInSearchBar() {
        searchBar.click();
        return this;
    }

    @Step("Ввод ключевого слова '{keyWord}'")
    public MainPage enterSearchWord(String keyWord) {
        String[] searchQuery = keyWord.split(" ");
        searchBar.setValue(searchQuery[0]);
        if (searchQuery.length != 1) {
            for (int i = 1; i < searchQuery.length; i++) {
                searchBar.append(" ").append(searchQuery[i]);
            }
        }
        return this;
    }

    @Step("Поиск по ключевому слову")
    public MainPage searchByKeyword() {
        searchBar.pressEnter();
        return this;
    }

    @Step("Дождаться появления полного поискового запроса в предложенной строке поиска")
    public MainPage waitFullRequest(String value) {
        searchListItem.shouldHave(text(value));
        return this;
    }

    @Step("Выбрать первый предложенный вариант категории поиска")
    public MainPage selectFirstSearchListItem() {
        searchListItem.click();
        return this;
    }

    @Step("Выбрать категорию '{value}' на главном экране")
    public MainPage chooseCategory(String value) {
        $("[data-marker='visual-rubricator/image-" + value + "']").click();
        return this;
    }

    @Step("Выбрать категорию товаров '{value}' из выпадающего списка")
    public MainPage selectSearchQueryFromDropDownList(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Добавление первого объявления в избранное")
    public MainPage addFirstAnnouncementInFavorite() {
        favoriteAnnouncement.get(0).click();
        return this;
    }

    @Step("Открыть избранные объявления")
    public MainPage openFavoriteAnnouncements() {
        headerFavorites.click();
        return this;
    }

    @Step("Нажать на кнопку 'Все избранные'")
    public MainPage pressButtonAllFavorites() {
        allFavorites.click();
        return this;
    }

    @Step("Сохранить название первого объявления на главной странице")
    public MainPage saveTitleTheFirstAnnouncement() {
        titleFirstAnnouncement = titlesOfAnnouncement.get(0).text();
        return this;
    }

    @Step("Открыть первое рекомендованное объявление")
    public MainPage openFirstAnnouncement() {
        linkFirstAnnouncement.click();
        return this;
    }

    @Step("Нажать 'Вход и регистрация'")
    public MainPage pressLoginButton() {
        loginButton.click();
        return this;
    }
}