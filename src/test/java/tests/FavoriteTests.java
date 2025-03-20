package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.CatalogPage;
import pages.FavoritePage;
import pages.ItemPage;
import utils.SelenideUtils;

@Feature("Тестирование добавления в избранное и просмотр без активного аккаунта")
@Tags({
        @Tag("webFavorite"),
        @Tag("withoutLogin")
})

public class FavoriteTests extends TestBase {

    final AuthPage authPage = new AuthPage();
    final FavoritePage favoritePage = new FavoritePage();
    final CatalogPage catalogPage = new CatalogPage();
    final SelenideUtils selenideUtils = new SelenideUtils();
    final ItemPage itemPage = new ItemPage();

    @Test
    @DisplayName("Добавление объявления в избранное и просмотр через кнопку 'Избранное' наверху страницы")
    @Tag("BLOCKER")
    public void addAnnouncementInFavoritesWithoutViewingTest() {
        mainPage.addFirstAnnouncementInFavorite()
                .openFavoriteAnnouncements();
        favoritePage.checkPageTitleTextH1("Избранное")
                .checkTheNumberOfFavoriteAnnouncements("Все 1");
    }

    @Test
    @DisplayName("Добавление объявления в избранное с возможностью посмотреть его сбоку страницы")
    @Tag("SMOKE")
    public void addAnnouncementInFavoritesWithViewingTest() {
        mainPage.addFirstAnnouncementInFavorite();
        selenideUtils.refreshPage();
        mainPage.pressButtonAllFavorites();
        favoritePage.checkPageTitleTextH1("Избранное")
                .checkTheNumberOfFavoriteAnnouncements("Все 1");
    }

    @Test
    @DisplayName("Неудачное добавление поиска объявлений в избранное, необходима авторизация")
    @Tag("BLOCKER")
    public void unsuccessfulAddAnnouncementsSearchInFavoritesTest() {
        mainPage.enterSearchWord("Скунс")
                .searchByKeyword();
        catalogPage.pressSaveSearch();
        authPage.checkOpenLoginForm("Вход");
    }

    @Test
    @DisplayName("Неудачная подписка на продавца, необходима авторизация")
    @Tag("BLOCKER")
    public void unsuccessfulSubscribeToSellerTest() {
        mainPage.saveTitleTheFirstAnnouncement()
                .openFirstAnnouncement();
        selenideUtils.goToActiveTab();
        itemPage.checkTitleAnnouncement(mainPage.titleFirstAnnouncement)
                .subscribeFavoriteSeller();
        authPage.checkOpenLoginForm("Вход");
    }
}