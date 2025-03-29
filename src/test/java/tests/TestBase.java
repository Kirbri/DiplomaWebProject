package tests;

import com.codeborne.selenide.Selenide;
import config.ConfigRunner;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.browser;
import static io.qameta.allure.Allure.step;

public class TestBase {

    final MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUp() {
        new ConfigRunner();
    }

    @BeforeEach
    void beforeEach() {
        step("Открытие главной страницы", () -> {
            mainPage.openMainPage()
                    .checkLoadingHeaderNavigation("Авито — сайт объявлений");
        });

        step("Выбор локации и принятие информации о сборе куков", () -> {
            mainPage.closeModuleAnimation()
                    .closeCookieInformation()
                    .pressChangeLocation()
                    .clearFieldLocation()
                    .enterSearchLocation("Все регионы")
                    .checkAndChooseEnteredLocation("Все регионы")
                    .selectLocationFromDropDownList()
                    .checkCurrentLocation("Во всех регионах");
        });
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (browser.equals("chrome")) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}