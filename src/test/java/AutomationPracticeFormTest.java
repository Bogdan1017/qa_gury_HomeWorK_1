import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest {

        //https://demoqa.com/automation-practice-form
        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
            Configuration.holdBrowserOpen = true;
        }

        @Test
        void fillFormTest() {
            open("/automation-practice-form");
            $("[class=practice-form-wrapper]").shouldHave(text("Student Registration Form"));
           // Selenide.executeJavaScript("$('#fixedban').remove()");


            $("[id=firstName]").setValue("Lionel");   //Enter first name
            $("[id=lastName]").setValue("Messi");     // Enter last name
            $("[id=userEmail]").setValue("t1346est1@gmail.com"); // Enter Emai

//          $("[id=gender-radio-1]").click();                 // Wrong
//            $("[id=gender-radio-1]").parent().click();  // Select gender
      $("#genterWrapper").$(byText("Male")).click();      //best
//            $("[label for=gender-radio-1]").parent().click();//good

            $("[id=userNumber]").setValue("0000000000");      // Enter phone number

            $("[id=dateOfBirthInput]").click(); //Select date of birth
            $("[class=react-datepicker__month-select]").selectOption("July");

            $("[class=react-datepicker__year-select").selectOption("2008");

            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

            $("[id=subjectsInput]").setValue("Math").pressEnter();
//            $("[id=hobbies-checkbox-1]").parent().click();
            $("#hobbiesWrapper").$(byText("Sports")).click();      //best

            // Upload file (спочатку потрібно завантажити файл в папку resources)
//            $("[id=uploadPicture]").uploadFile(new File("src/test/resources/img/1.png"));
           $("[id=uploadPicture]").uploadFromClasspath("img/1.png"); // best



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

