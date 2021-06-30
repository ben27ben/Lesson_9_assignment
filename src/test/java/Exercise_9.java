import objrctPage.SeleniumPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.border.TitledBorder;
import java.util.List;

public class Exercise_9 extends SeleniumPageObject {

    public static FirefoxDriver ffdriver;

    @BeforeClass
    public void enterdriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\benv\\Downloads\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\benv\\Downloads\\geckodriver.exe");
    }



    @Test (priority = 1)
    public void Exercise1(){
        driver = new ChromeDriver();
        driver.get("https://www.walla.co.il ");
        ffdriver = new FirefoxDriver();
        ffdriver.get("https://www.ynet.co.il");
    }
    @Test (priority = 2)
    public void Exercisetwoandthree() {
        String ynetTitle = "ynet - חדשות, כלכלה, ספורט ובריאות - דיווחים שוטפים מהארץ ומהעולם";
        ffdriver.navigate().refresh();
        Assert.assertEquals(ffdriver.getTitle(), ynetTitle);
        System.out.println(ffdriver.getTitle().contentEquals(ynetTitle));
    }

//    String chromeUrl = driver.getCurrentUrl();
//    String chromeTitle = driver.getTitle();

    @Test (priority = 3)
    public void Exercise4(){
    driver.get("https://translate.google.com");
        System.out.println(driver.findElement(By.className("er8xn")));
        System.out.println(driver.findElement(By.tagName("textarea")));
    }
    @Test (priority = 4)
    public void Exercise5(){
        ffdriver.get("https://www.youtube.com");
        System.out.println(ffdriver.findElement(By.id("search-icon-legacy")));
    }
    @Test (priority = 5)
    public void Exercise6(){
     ffdriver.get("https://www.selenium.dev");
        ffdriver.findElement(By.id("gsc-i-id1")).sendKeys("selenium");
    }
    @Test (priority = 6)
    public void Exercise7(){
      driver.get("https://www.amazon.com");
      String amzTitle = "Amazon.com. Spend less. Smile more.";
      Assert.assertEquals(driver.getTitle(), amzTitle);
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
      driver.findElement(By.id("nav-search-submit-button")).click();
    }
    @Test (priority = 7)
    public void Exercise8(){
    driver.get("https://translate.google.com");
    driver.findElement(By.tagName("textarea")).sendKeys("מה נשמע");
    }

    @Test (priority = 8)
    public void Exercise9(){
    driver.get("https://www.youtube.com");
    driver.findElement(By.id("search")).sendKeys("we are the world");
    driver.findElement(By.id("search-icon-legacy")).click();
    }
    @Test (priority = 9)
    public void Exercise10(){
    driver.get("https://dgotlieb.github.io/Controllers/");
        List<WebElement> elements = driver.findElements(By.name("group1"));
        for (int i = 0; i < elements.size(); i++){
            if (elements.get(i).getAttribute("value").equals("Cheese")){
                elements.get(i).click();
            }
        }
        Select dropDown = new Select(driver.findElement(By.name("dropdownmenu")));
        List<WebElement> e = dropDown.getOptions();
        int itemCount = e.size();

        for(int l = 0; l < itemCount; l++)
        {
            System.out.println(e.get(l).getText());
        }
    }
    @Test (priority = 10)
    public void Exercise11(){
    driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("admin");
        driver.findElement(By.id("pass")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    @Test (priority = 11)
    public void Exercise12(){
    driver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(driver.findElement(By.id("seven")).getSize());
        System.out.println(driver.findElement(By.id("six")).isDisplayed());
    driver.findElement(By.id("seven")).click();
    driver.findElement(By.id("add")).click();
    driver.findElement(By.id("four")).click();
    driver.findElement(By.id("equal")).click();

    String result = driver.findElement(By.id("screen")).getText();
    String actualresult = "11";
    Assert.assertEquals(result, actualresult);
    }
    @Test (priority = 12)
    public void Exercise13(){
    driver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(driver.findElement(By.id("two")).getRect().getHeight());
        System.out.println(driver.findElement(By.id("six")).getRect().getWidth());
    }
    @Test (priority = 13)
    public void Exercise14(){
        ChromeOptions options = new ChromeOptions();
        options. addArguments("--disable-extensions");
        options = new ChromeOptions();

    }
    @AfterClass
    public void closeall(){
        driver.quit();
        ffdriver.quit();
    }
    
    }








