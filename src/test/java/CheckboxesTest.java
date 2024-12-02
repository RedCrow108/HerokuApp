import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Не явное ожидание перед поиском элемента
    }

    @Test
    public void checkCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Assert.assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected()); // Проверяем что первый чекбокс unchecked
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click(); // Активируем первый чекбокс
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected()); // Проверяем что первый чекбокс checked
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected()); // Проверяем что второй чекбокс checked
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click(); // Активируем второй чекбокс
        Assert.assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected()); // Проверяем что второй чекбокс unchecked
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
