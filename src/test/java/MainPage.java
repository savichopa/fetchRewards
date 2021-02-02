import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@id,'left')]")
    public List<WebElement> leftSide;
    @FindBy(xpath = "//input[contains(@id,'right')]")
    public List<WebElement> rightSide;
    @FindBy(id = "weigh")
    public WebElement weigh;
    @FindBy(xpath = "(//button[@id='reset'])[2]")
    public WebElement reset;
    @FindBy(xpath = "//button[contains(@id,'coin')]")
    List<WebElement> coins;
    @FindBy(xpath = "(//*[@id=\"reset\"])[1]")
    public WebElement result;
}