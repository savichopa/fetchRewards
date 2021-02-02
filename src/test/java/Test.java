import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    @org.testng.annotations.Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        driver.navigate().to("http://ec2-54-208-152-154.compute-1.amazonaws.com/");

        int[] current = {1, 2, 3, 4, 5, 6, 7, 8};

        current = populateNumbersAndCheckWeigh(current, mainPage);
        mainPage.reset.click();
        current = populateNumbersAndCheckWeigh(current, mainPage);
        mainPage.reset.click();
        current = populateNumbersAndCheckWeigh(current, mainPage);
        mainPage.coins.get(current[0]).click();
        System.out.print(driver.switchTo().alert().getText());
    }

    private List<int[]> getTwoArrays(int[] num) {
        List<int[]> list = new ArrayList<>();
        int[] firstHalf = Arrays.copyOfRange(num, 0, num.length / 2);
        int[] secondHalf = Arrays.copyOfRange(num, num.length / 2, num.length);
        list.add(firstHalf);
        list.add(secondHalf);
        return list;
    }

    // populate numbers
    private int[] populateNumbersAndCheckWeigh(int[] current, MainPage mainPage) {
        List<int[]> list = getTwoArrays(current);
        for (int i = 0; i < list.size(); i++) {
            for (int y = 0; y < list.get(i).length; y++) {
                if (i == 1)
                    mainPage.rightSide.get(y).sendKeys(list.get(i)[y] + "");
                else mainPage.leftSide.get(y).sendKeys(list.get(i)[y] + "");
            }
        }
        //check less weigh
        mainPage.weigh.click();
        if (mainPage.result.getText().contains(">")) {
            current = list.get(1);
        } else if (mainPage.result.getText().contains("<"))
            current = list.get(0);
        else current = new int[]{0};
        return current;
    }

}

