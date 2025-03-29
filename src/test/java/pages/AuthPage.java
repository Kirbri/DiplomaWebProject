package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final SelenideElement loginForm = $("[data-marker='login-form']"),
            loginFormSubmit = $("[data-marker='login-form/submit']"),
            fieldError = $("[data-marker='field/error']"),
            loginFormLoginInput = $("[data-marker='login-form/login/input']"),
            loginFormPasswordInput = $("[data-marker='login-form/password/input']"),
            hrefFirstPage = $("[href='https://www.geetest.com/first_page']");

    @Step("Проверка открытия формы входа в аккаунт")
    public AuthPage checkOpenLoginForm(String value) {
        loginForm.shouldHave(text(value));
        return this;
    }

    @Step("Нажать кнопку 'Войти'")
    public AuthPage pressButtonEnter() {
        loginFormSubmit.click();
        return this;
    }

    @Step("Ошибка при незаполнении логина или пароля - 'Заполните поле'")
    public AuthPage errorFillField(String value) {
        fieldError.shouldHave(text(value));
        return this;
    }

    @Step("Ввести логин - {value}")
    public AuthPage enterLogin(String value) {
        loginFormLoginInput.setValue(value);
        return this;
    }

    @Step("Ввести пароль - {value}")
    public AuthPage enterPassword(String value) {
        loginFormPasswordInput.setValue(value);
        return this;
    }

    @Step("Проверка наличия капчи")
    public AuthPage checkCaptcha() {
        hrefFirstPage.shouldBe(exist);
        return this;
    }
}