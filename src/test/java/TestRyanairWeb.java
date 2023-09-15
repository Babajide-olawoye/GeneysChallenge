import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRyanairWeb {
    WebDriver webDriver;
    @BeforeClass
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.ryanair.com/");
    }
    @Test
    public void first(){

    }

    @AfterClass
    public void close(){
        webDriver.close();
    }
}
