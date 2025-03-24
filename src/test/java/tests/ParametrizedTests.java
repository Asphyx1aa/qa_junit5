package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TextBoxPage;

import java.util.stream.Stream;

public class ParametrizedTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    // Параметризированный тест с использованием ValueSource

    @ParameterizedTest(name = "Проверка валидации поле 'Имя' при вводе {0}")
    @ValueSource(strings = { "Андрей", "Andrei", "!#!@#$%$", "32423423" })
    void successfulFillFormUsingValueSource(String name) {
        textBoxPage
                .openPage()
                .setUserName(name)
                .setUserMail("test@test.ru")
                .setUserAddress("Test address 1")
                .setUserPermAddress("Test address 2")
                .submitForm()
                .checkNameResult(name);
    }

    // Параметризированный тест с использованием CsvSource

    @ParameterizedTest(name = "Проверка формы при заполнении данными {0} {1} {2} {3}")
    @CsvSource({
            "Andrei, test@test.ru, Test address 1, Test address 2",
            "Andrei, test@test.ru, Test address 1, Test address 2",
    })
    void successfulFillFormUsingCsvSource(String name, String email, String address, String permAddress) {
        textBoxPage
                .openPage()
                .setUserName(name)
                .setUserMail(email)
                .setUserAddress(address)
                .setUserPermAddress(permAddress)
                .submitForm()
                .checkNameResult(name)
                .checkEmailResult(email)
                .checkAddressResult(address)
                .checkPermAddressResult(permAddress);
    }

    // Параметризированный тест с использованием MethodSource

    @ParameterizedTest(name = "Проверка валидации поле 'Имя' при вводе {0}")
    @MethodSource("stringProvider")
    void successfulFillFormUsingMethodSource(String name) {
        textBoxPage
                .openPage()
                .setUserName(name)
                .setUserMail("test@test.ru")
                .setUserAddress("Test address 1")
                .setUserPermAddress("Test address 2")
                .submitForm()
                .checkNameResult(name);
    }

    static Stream<String> stringProvider() {
        return Stream.of("Андрей", "Andrei", "!#!@#$%$", "32423423");
    }


}