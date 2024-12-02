import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
public class AddRemoveElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Не явное ожидание перед поиском элемента
    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click(); // Добавление первого элемента
        driver.findElement(By.xpath("//button[text()='Add Element']")).click(); // Добавление второго элемента
        driver.findElement(By.xpath("//button[text()='Delete']")).click(); // Удаление одного элемента
        List<WebElement> elements = driver.findElements(By.xpath("//button[text()='Delete']")); // Считывание списка элементов
        Assert.assertEquals(1, elements.size()); // Проверка что количество элементов из списка равно 1
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
