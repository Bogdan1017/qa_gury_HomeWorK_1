import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest {

        //https://demoqa.com/automation-practice-form
        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
        }

        @Test
        void fillFormTest() {
            open("/automation-practice-form");
            $("[id=firstName]").setValue("Lionel");   //Enter first name
            $("[id=lastName]").setValue("Messi");     // Enter last name
            $("[id=userEmail]").setValue("t1346est1@gmail.com"); // Enter Email
            $("[id=gender-radio-1]").click();                 // Select gender
            $("[id=userNumber]").setValue("0000000000");      // Enter phone number

            $("[id=dateOfBirthInput]").click(); //Select date of birth
            $("[class=react-datepicker__month-select]").click();
            $("[class=react-datepicker__month-select] option[value='8']").click();
            $("[class=react-datepicker__year-select").click();
            $("[class=react-datepicker__year-select] option[value='1997']").click();
            $("[class=react-datepicker__day--017]").click();

            $("[class=subjects-auto-complete__control css-yk16xz-control]").setValue("I like football");
            $("[id=hobbies-checkbox-1]").click();

            // Знаходимо інпут для завантаження файлу
            SelenideElement uploadInput = $("[id=uploadPicture]");

            // Вказуємо шлях до файлу, який хочемо завантажити
            File fileToUpload = new File("D:/Картинки/TEST.JPG");

            // Завантажуємо файл через Selenide
            uploadInput.uploadFile(fileToUpload);

            $("[id=currentAddress]").setValue("New York, Bayker street 1");

            $("[id=state]").click();
            $("[id=react-select-3-input]").setValue("Haryana");
            $("[id=react-select-3-input]").pressEnter();

            $("[id=city]").click();
            $("[id=react-select-4-input]").setValue("Karnal");
            $("[id=react-select-4-input]").pressEnter();

            $("[id=submit]").click();

            $("[class=modal-content]").shouldHave(text("Lionel"),text("Messi"),
                    text("t1346est1@gmail.com"),text("Male"),text("0000000000"));



        }
    }

