package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import utils.RandomUtils;

@Feature("Тестирование входа в аккаунт случайными данными")

@Tags({
        @Tag("webLogin"),
        @Tag("withoutLogin")
})
public class LoginTest extends TestBase {

    final AuthPage authPage = new AuthPage();
    final RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Ошибка входа при незаполненном логине и пароле - 'Заполните поле'")
    @Tag("BLOCKER")
    public void loginErrorWithEmptyLoginAndPasswordTest() {
        mainPage.pressLoginButton();
        authPage.checkOpenLoginForm("Вход")
                .pressButtonEnter()
                .errorFillField("Заполните поле");
    }

    @Test
    @DisplayName("Ошибка входа при незаполненном пароле - 'Заполните поле'")
    @Tag("BLOCKER")
    public void loginErrorWithEmptyPasswordTest() {
        mainPage.pressLoginButton();
        authPage.checkOpenLoginForm("Вход")
                .enterLogin(randomUtils.getRandomMobilePhoneNumber())
                .pressButtonEnter()
                .errorFillField("Заполните поле");
    }

    @Test
    @DisplayName("Ошибка входа при незаполненном логине - 'Заполните поле'")
    @Tag("SMOKE")
    public void loginErrorWithEmptyLoginTest() {
        mainPage.pressLoginButton();
        authPage.checkOpenLoginForm("Вход")
                .enterPassword(randomUtils.getRandomPassword())
                .pressButtonEnter()
                .errorFillField("Заполните поле");
    }

    @Test
    @DisplayName("""
            Появление капчи при заполнении некорректных логина и пароля, ошибка 'Почта не привязана к профилю.\s
            Проверьте, нет ли опечаток, или войдите по телефону'""")
    @Tag("BLOCKER")
    public void inputLoginAndPasswordThenCaptchaTest() {
        mainPage.pressLoginButton();
        authPage.checkOpenLoginForm("Вход")
                .enterLogin(randomUtils.getRandomEmailAddress())
                .enterPassword(randomUtils.getRandomPassword())
                .pressButtonEnter()
                .checkCaptcha();
    }

    @Test
    @DisplayName("""
            Появление капчи при заполнении некорректного по длине логина, ошибка 'Длина логина не должна\s
            превышать 64 символа'""")
    @Tag("SMOKE")
    public void inputLoginMore64SymbolsAndPasswordThenCaptchaTest() {
        mainPage.pressLoginButton();
        authPage.checkOpenLoginForm("Вход")
                .enterLogin(randomUtils.getRandomPhoneNumberWithLength(65))
                .enterPassword(randomUtils.getRandomPassword())
                .pressButtonEnter()
                .checkCaptcha();
    }
}