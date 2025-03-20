package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    private final SelenideElement titleInfoText = $("[data-marker='item-view/title-info']"),
            roleButtonFavoriteSellerSubscription = $("[data-marker='favorite-seller-subscription-button']"),
            buttonFavoriteSellersTooltipReference = $("[data-marker='favorite-sellers-tooltip/reference']");

    @Step("Проверить соответствие названий '{value}' объявлений")
    public ItemPage checkTitleAnnouncement(String value) {
        titleInfoText.shouldHave(text(value));
        return this;
    }

    @Step("Подписаться на продавца")
    public ItemPage subscribeFavoriteSeller() {
        if (roleButtonFavoriteSellerSubscription.exists()) {
            roleButtonFavoriteSellerSubscription.click();
        } else {
            buttonFavoriteSellersTooltipReference.click();
        }
        return this;
    }
}
