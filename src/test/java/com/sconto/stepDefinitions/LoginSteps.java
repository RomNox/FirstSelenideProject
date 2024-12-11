package com.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.sconto.pages.HomePage;
import com.sconto.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginSteps {

    HomePage home;
    LoginPage login;

    @And("User enters valid data")
    public void enter_valid_data() {
        // Получение страницы логина и ввод корректных данных
        login = Selenide.page(LoginPage.class);
        login.enterData("romaykin@gmail.com", "d2riN9bGzR5&Uh5");
    }

    @And("User clicks on Anmelden button")
    public void click_on_Anmelden() {
        // Клик по кнопке "Anmelden"
        login.clickOnAnmelden();
    }

    @And("User enters invalid email and password")
    public void user_enters_invalid_email_and_password() {
        // Получение страницы логина и ввод некорректных данных
        login = Selenide.page(LoginPage.class);
        login.enterData("invalidemail@example.com", "wrongpassword");
    }

    @Then("User sees an error message for invalid login")
    public void user_sees_an_error_message_for_invalid_login() {
        // Проверка отображения сообщения об ошибке с ожидаемым текстом
        login.verifyErrorMessage("Benutzername nicht gefunden oder Passwort falsch."); // Обновлен текст ошибки на немецкий
    }

    @Then("User verifies Login form is displayed")
    public void verify_Login_form() {
        // Проверка заголовка страницы логина
        login = Selenide.page(LoginPage.class);
        login.verifyLoginTitle(); // Метод без аргументов
    }
}
