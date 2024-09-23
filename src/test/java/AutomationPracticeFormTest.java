import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class AutomationPracticeFormTest {
    public class TextBoxTests {
        //https://demoqa.com/automation-practice-form
        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
        }

    }
}
