import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class InputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Не явное ожидание перед поиском элемента
    }

    @Test
    public void checkInputs() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys("1"); // Находим поле и вводим туда цифру 1
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_UP);
        String currentValue = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).getAttribute("value");
        Assert.assertEquals(currentValue, "2");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
        currentValue = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).getAttribute("value");
        Assert.assertEquals(currentValue, "-1");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys("prst");
        currentValue = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).getAttribute("value");
        Assert.assertEquals(currentValue, "-1");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
