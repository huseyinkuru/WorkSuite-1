package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class=\"accordionItem closeIt\"]/a/span")
    List<WebElement> homeMenuButton;

    @FindBy(xpath = "/html/body/aside/div[2]/div[2]/ul/li[1]/div/a")
    List<WebElement> dashboardSubCategories;

    public void clickMainMenu(String buttonName){
        for (WebElement el:homeMenuButton){
            System.out.println(el.getText());
            if (el.getText().equals(buttonName)){
                el.click();
                break;
            }
        }
    }

    public void clickDashboardSubCategory(String buttonName){
        for (WebElement el:dashboardSubCategories){
            if (el.getText().equals(buttonName)){
                el.click();
                break;
            }
        }
    }
}