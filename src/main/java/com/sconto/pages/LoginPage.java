package com.sconto.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @FindBy(css = ".existingAccount__headline")
    private WebElement loginTitle;

    private static final String EXPECTED_LOGIN_TITLE = "Anmelden"; // Ожидаемый текст заголовка

    // Метод для проверки заголовка страницы логина
    public void verifyLoginTitle() {
        $(loginTitle).shouldHave(text(EXPECTED_LOGIN_TITLE));
    }

    // Локатор для поля ввода email
    @FindBy(id = "loginEmail")
    private WebElement emailField;

    // Локатор для поля ввода пароля
    @FindBy(id = "loginPassword")
    private WebElement passwordField;

    // Метод для ввода данных (email и пароль)
    public LoginPage enterData(String email, String password) {
        $(emailField).val(email);
        $(passwordField).val(password);
        return Selenide.page(this);
    }

    // Локатор для кнопки логина
    @FindBy(id = "login-submit")
    private WebElement loginButton;

    // Метод для клика по кнопке "Anmelden"
    public HomePage clickOnAnmelden() {
        $(loginButton).click();
        return Selenide.page(HomePage.class);
    }

    // Локатор для сообщения об ошибке
    @FindBy(css = "#loginEmail-error") // Убедитесь, что селектор соответствует реальной разметке
    private WebElement errorMessage;

    // Метод для проверки текста сообщения об ошибке
    public void verifyErrorMessage(String expectedMessage) {
        $(errorMessage).shouldHave(text("Benutzername nicht gefunden oder Passwort falsch.")); // Текст ошибки на немецком
    }
}
