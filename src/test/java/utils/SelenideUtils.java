package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class SelenideUtils {

    @Step("Перейти на новую вкладку")
    public void goToActiveTab() {
        String newTabHandle = WebDriverRunner.getWebDriver().getWindowHandles().stream()
                .filter(handle -> !handle.equals(WebDriverRunner.getWebDriver().getWindowHandle()))
                .findFirst()
                .orElseThrow();
        switchTo().window(newTabHandle);
    }

    @Step("Обновить страницу")
    public void refreshPage() {
        Selenide.refresh();
    }
}