import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GitHubHoverAndRectangleTest {
    private static final SelenideElement SOLUTIONS_BUTTON = $x("//button[contains(text(),'Solutions')]");
    private static final SelenideElement ENTERPRISE_BUTTON = $x("//a[contains(@data-analytics-event,'click to go to Enterprise')]");
    private static final SelenideElement TITLE = $x("//h1[contains(@class,'h1-mktg')][@style]");
    private static final SelenideElement DRAGNDROP_ELEMENT_A = $x("//div[@id='column-a']");
    private static final SelenideElement DRAGNDROP_ELEMENT_B = $x("//div[@id='column-b']");


    @Test
    public void checkTitleEnterprise() {
        open("https://github.com/");
        Configuration.browserSize = "1920x1080";

        SOLUTIONS_BUTTON.hover();
        ENTERPRISE_BUTTON.click();
        TITLE.shouldHave(Condition.exactText("Build like the best"));
    }

    @Test
    public void dragAndDropRectangle(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Configuration.browserSize = "1920x1080";

        DRAGNDROP_ELEMENT_A.dragAndDropTo(DRAGNDROP_ELEMENT_B);
        DRAGNDROP_ELEMENT_A.shouldHave(Condition.exactText("B"));
        DRAGNDROP_ELEMENT_B.shouldHave(Condition.exactText("A"));

    }
}
