package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    SelenideElement userNameInput = $("#userName");
    SelenideElement userMailInput = $("#userEmail");
    SelenideElement userAddressInput = $("#currentAddress");
    SelenideElement userPermAddressInput = $("#permanentAddress");
    SelenideElement submitButton = $("#submit");
    SelenideElement nameResult = $("#name");
    SelenideElement emailResult = $("#email");
    SelenideElement addressResult = $("#output").$("#currentAddress");
    SelenideElement permAddressResult = $("#output").$("#permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setUserName(String name) {
        userNameInput.setValue(name);
        return this;
    }

    public TextBoxPage setUserMail(String email) {
        userMailInput.setValue(email);
        return this;
    }

    public TextBoxPage setUserAddress(String address) {
        userAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setUserPermAddress(String permAddress) {
        userPermAddressInput.setValue(permAddress);
        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkNameResult(String name) {
        nameResult.shouldHave(text(name));
        return this;
    }

    public TextBoxPage checkEmailResult(String email) {
        emailResult.shouldHave(text(email));
        return this;
    }

    public TextBoxPage checkAddressResult(String address) {
        addressResult.shouldHave(text(address));
        return this;
    }

    public TextBoxPage checkPermAddressResult(String permAddress) {
        permAddressResult.shouldHave(text(permAddress));
        return this;
    }


}
