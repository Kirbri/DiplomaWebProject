package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;


@Feature("Тестирование поиска объявлений без активного аккаунта")

@Tags({
        @Tag("webSearch"),
        @Tag("withoutLogin")
})
public class SearchTests extends TestBase {

    final CatalogPage catalogPage = new CatalogPage();

    @CsvFileSource(resources = "/test_data/searchWordInRootCategoryAnimalsWith0ResultTest.csv")
    @ParameterizedTest(name = """
            Поиск объявлений по ключевому слову - {2} через корневую категорию 'Животные', подкатегории - {1} с 0 результатом""")
    @Tag("BLOCKER")
    public void searchWordInRootCategoryAnimalsWith0ResultTest(int subcategoryNum, String subcategoryText,
                                                               String searchWord) {
        mainPage.clickAllCategories()
                .clickRootCategory(26098)
                .clickMoreCategories()
                .chooseSubCategory(subcategoryNum)
                .enterSearchWord(searchWord)
                .waitFullRequest(searchWord.toLowerCase())
                .searchByKeyword();
        catalogPage.checkBreadcrumbsText(subcategoryText)
                .checkPageTitleTextOnRequest(searchWord)
                .checkNotVisiblePageTitleCount()
                .checkNoResultsTitle("Ничего не найдено в выбранной области поиска");
    }

    @ValueSource(strings = {
            "Apple tv",
            "Тестирование selenide",
            "Cd`rkf",
            "Рыбалка",
            "Как купить ухо онлайн и без регистрации"

    })
    @ParameterizedTest(name = "Поиск объявлений по ключевому слову - {0}, с результатом больше 0 без выбора категории")
    @Tag("BLOCKER")
    public void searchWordWithoutRootCategoryWithResultMore0Test(String expectedValue) {
        mainPage.enterSearchWord(expectedValue)
                .searchByKeyword();
        catalogPage.checkBreadcrumbsText("Главная")
                .checkPageTitleTextOnRequest(expectedValue)
                .checkVisiblePageTitleCount();
    }

    @CsvFileSource(resources = "/test_data/searchResultGreat0WithCategoriesTest.csv")
    @ParameterizedTest(name = """
            Поиск объявлений по ключевому слову - {0}, c результатом больше 0 и с выбором первой выпадающей\s
            категории - {1}""")
    @Tag("SMOKE")
    public void searchResultGreat0WithCategoriesTest(String searchWord, String categoryText, String foundWord) {
        mainPage.enterSearchWord(searchWord)
                .waitFullRequest(foundWord)
                .selectFirstSearchListItem();
        catalogPage.checkBreadcrumbsText(categoryText)
                .checkPageTitleTextOnRequest(foundWord)
                .checkVisiblePageTitleCount();
    }

    @CsvFileSource(resources = "/test_data/selectingPopularCategoriesOnMainPageTest.csv")
    @ParameterizedTest(name = "Выбор популярной категорий - {0}, на главной странице")
    @Tag("SMOKE")
    public void selectingPopularCategoriesOnMainPageTest(String popularCategory, int subcategory1, int subcategory2,
                                                         String categoryText1, String categoryText2, String foundWord) {
        mainPage.chooseCategory(popularCategory);
        catalogPage.clickMoreExpandButton()
                .chooseSubcategory(subcategory1)
                .chooseSubcategory(subcategory2)
                .checkBreadcrumbsText(popularCategory, categoryText1, categoryText2)
                .checkPageTitleTextByCategory(foundWord)
                .checkVisiblePageTitleCount();
    }

    @CsvSource(value = {
            "Вакансии,Работа и вакансии",
            "Автомобили,Купить автомобиль",
            "Снять квартиру (длительно),Аренда квартир на длительный срок",
            "Мобильные телефоны,Смартфоны и мобильные телефоны"
    })
    @ParameterizedTest(name = "Выбор категории - {0} в строке поиска из выпадающего списка")
    @Tag("SMOKE")
    public void selectCategoryInSearchBarFromDropDownListTest(String searchCategory, String expectedTitle) {
        mainPage.openDropDownListOfSuggestionsInSearchBar()
                .selectSearchQueryFromDropDownList(searchCategory);
        catalogPage.checkPageTitleTextByCategory(expectedTitle)
                .checkVisiblePageTitleCount();
    }
}