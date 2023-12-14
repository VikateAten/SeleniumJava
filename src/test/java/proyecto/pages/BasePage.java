package proyecto.pages;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    public void setup(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(driver,10);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

    }
    public BasePage(){

    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private WebElement FindID(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    public WebElement FindClasName(String  locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
    }

    public WebElement FindCssSelector(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
        Allure.addAttachment("Click", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void clickElementId(String locator){
        FindID(locator).click();
        Allure.addAttachment("Click", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void clickElementClasName(String locator){
        FindClasName(locator).click();
        Allure.addAttachment("Click", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void clickElementCssSelector(String locator){
        FindCssSelector(locator).click();
        Allure.addAttachment("Click", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


    public void writeId(String locator, String textToWrite){
        FindID(locator).clear();
        FindID(locator).sendKeys(textToWrite);
        Allure.addAttachment("Click", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


    public void writeIdAndEnter(String locator, String textToWrite){
        FindID(locator).clear();
        FindID(locator).sendKeys(textToWrite);
        Allure.addAttachment("Click", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        FindID(locator).sendKeys(Keys.RETURN);
    }



    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(FindID(locator));
        dropdown.selectByVisibleText(valueToSelect);
        Allure.addAttachment("Select", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


    public void selectElemList(String locator, String valueToSelect){
        List<WebElement> elements = driver.findElements(By.xpath(locator));
                for(WebElement elem:elements){

                    if(valueToSelect.equals(elem.getText())){
                        elem.click();
                       break;
                    }
                }
    }

    public void selectElemListCssName(String locator, String valueToSelect){

      List<WebElement> elements = driver.findElements(By.className(locator));

        for(WebElement elem:elements){

            System.out.println(elem.getText());

            if(valueToSelect.equals(elem.getText())){
                elem.click();
                break;
            }
        }
    }


     public void clickElemtJavaScript(String locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.cssSelector(locator));
        js.executeScript("arguments[0].click();", element);
         Allure.addAttachment("ClickJavaScript", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void cerrar(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", "Error");

                // Scroll Inicio
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scroll (0, 0) ");
                Allure.addAttachment(screenshotName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));


                System.out.println("Error en Escenario"+screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }


      public  void  selectYear(String locator, String year){

        Select dropdown = new Select(FindClasName(locator));
        dropdown.selectByVisibleText(year);
        Allure.addAttachment("SelectYear", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public  void  selectMonth(String locator, String month){

        Select dropdown = new Select(FindClasName(locator));
        dropdown.selectByVisibleText(month);
        Allure.addAttachment("SelectMonth", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }

    public  void  selectDay(String locator, String day){

        WebElement datapicker = FindCssSelector(locator);

        List<WebElement> days = datapicker.findElements(By.tagName("a"));

        for (WebElement elementday:days)
        {
            String  calDate = elementday.getAttribute("data-date");

            if(calDate.equals(day)){
                elementday.click();
                Allure.addAttachment("SelectDay", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

            }
        }

    }


}