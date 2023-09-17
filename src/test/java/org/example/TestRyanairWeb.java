package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;



public class TestRyanairWeb {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @BeforeClass
    private void setUp(){
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.get("https://www.ryanair.com/");
        webDriver.manage().window().maximize();
        //This clicks "Yes, I agree" regarding cookies
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/button[2]")).click();
    }


    @Test
    public void urlTest(){

        Assert.assertTrue(webDriver.getCurrentUrl().startsWith("https://www.ryanair.com/"));
    }

    @Test
    public void flightTest(){
        int expectedNumberOfPeople = 4;
        String expectedDepartureDate = "Wed, 20 Sept";
        String expectedReturnDate = "Tue, 26 Sept";
        int actualNUmberOfPeople;

        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys(Keys.BACK_SPACE);
        webDriver.findElement(By.id("input-button__departure")).sendKeys("Dublin");
        webDriver.findElement(By.id("input-button__destination")).sendKeys("Spain");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-id=\"BCN\"]")));

        webDriver.findElement(By.cssSelector("span[data-id=\"BCN\"]")).click();//click barcelona all airport

        webDriver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget-container/hp-search-widget/div/hp-flight-search-widget-container/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/fsw-flight-search-widget-controls/div[1]/div[2]/div/fsw-input-button[1]/div/div[2]")).click();//click departure
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-id=\"2023-09-20\"]")));
        webDriver.findElement(By.cssSelector("div[data-id=\"2023-09-20\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calendar-body__cell-wrap--start-highlight")));
        webDriver.findElement(By.cssSelector("div[data-id=\"2023-09-26\"]")).click();
        webDriver.findElement(By.cssSelector(".passengers-picker__passenger-type:nth-child(3) .counter__button-wrapper--enabled:nth-child(3)")).click();
        webDriver.findElement(By.cssSelector(".passengers-picker__passenger-type:nth-child(4) .counter__button-wrapper--enabled")).click();
        webDriver.findElement(By.cssSelector(".passengers-picker__passenger-type:nth-child(5) .counter__button-wrapper--enabled")).click();
        webDriver.findElement(By.cssSelector(".flight-search-widget__start-search-cta")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".details__edit-search")));
        webDriver.findElement(By.cssSelector(".details__edit-search")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flight-widget-controls__control--passengers .input-button__input")));
        webDriver.findElement(By.cssSelector(".flight-widget-controls__control--passengers .input-button__input")).click();

        int numberOfAdult = Integer.parseInt(webDriver.findElement(By.cssSelector(".passengers-picker__passenger-type:nth-child(3) .counter__value")).getText());
        int numberOfTeen = Integer.parseInt(webDriver.findElement(By.cssSelector(".passengers-picker__passenger-type:nth-child(4) .counter__value")).getText());
        int numberOfChildren = Integer.parseInt(webDriver.findElement(By.cssSelector(".passengers-picker__passenger-type:nth-child(5) .counter__value")).getText());
        actualNUmberOfPeople = numberOfTeen + numberOfChildren + numberOfAdult;
        String actualDepartureDate = webDriver.findElement(By.cssSelector(".ng-trigger-datesFromTripTypeChange .input-button__input")).getText();
        String actualReturnDate = webDriver.findElement(By.cssSelector(".ng-trigger-smoothPickerAppear .input-button__input")).getText();
        WebElement flightList = webDriver.findElement(By.cssSelector(".ng-star-inserted"));

        Assert.assertEquals(actualNUmberOfPeople, expectedNumberOfPeople);
        Assert.assertEquals(actualDepartureDate, expectedDepartureDate);
        Assert.assertEquals(actualReturnDate, expectedReturnDate);
        Assert.assertTrue(flightList.isDisplayed());
    }

    @Test(dependsOnMethods = "flightTest")
    public void sectionsTest (){
        String expectedLoginSectionText = "Log in to myRyanair";
        String expectedPassengersSectionText = "Passengers";
        String actualLoginSectionText;
        String actualPassengersSectionText;

        webDriver.findElement(By.cssSelector(".flight-card-summary__select-btn")).click();
        webDriver.findElement(By.cssSelector(".flight-card-summary__select-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fare-table__fare-column:nth-child(3) > .fare-table__fare-column-border")));
        webDriver.findElement(By.cssSelector(".fare-table__fare-column:nth-child(3) > .fare-table__fare-column-border")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-touchpoint__title")));

        actualLoginSectionText = webDriver.findElement(By.cssSelector(".login-touchpoint__title")).getText();
        actualPassengersSectionText = webDriver.findElement(By.cssSelector(".app-title")).getText();
        WebElement passengerSection = webDriver.findElement(By.cssSelector(".form-wrapper"));



        Assert.assertEquals(actualLoginSectionText, expectedLoginSectionText);
        Assert.assertEquals(actualPassengersSectionText, expectedPassengersSectionText);
        Assert.assertTrue(passengerSection.isDisplayed());

    }

    @Test(dependsOnMethods = "sectionsTest")
    public void passengerSectionTest(){
        WebElement passengerSection = webDriver.findElement(By.id("form.passengers.ADT-0.name"));
        boolean isPassengerSectionClickable = true;

        try {
            passengerSection.click();
        }
        catch (ElementClickInterceptedException e){
            isPassengerSectionClickable = false;
        }
        Assert.assertFalse(isPassengerSectionClickable);

        webDriver.findElement(By.cssSelector(".login-touchpoint__expansion-bar")).click();


        try {
            isPassengerSectionClickable = true;
            passengerSection.click();
        }
        catch (ElementClickInterceptedException e){
            isPassengerSectionClickable = false;
        }
        Assert.assertTrue(isPassengerSectionClickable);

    }

    @Test(dependsOnMethods = "passengerSectionTest")
    public void sittingPageTest(){

        Ryanair_Passenger ryanairPassenger1 = new Ryanair_Passenger(webDriver, 1, "Adult", 0);
        ryanairPassenger1.enterPassengerTitle("Mr.");
        ryanairPassenger1.enterPassengerFirstName("Joshua");
        ryanairPassenger1.enterPassengerLastName("Ola");

        Ryanair_Passenger ryanairPassenger2 = new Ryanair_Passenger(webDriver, 2, "Adult", 1);
        ryanairPassenger2.enterPassengerTitle("Mrs.");
        ryanairPassenger2.enterPassengerFirstName("Joanna");
        ryanairPassenger2.enterPassengerLastName("Ola");

        Ryanair_Passenger ryanairPassenger3 = new Ryanair_Passenger(webDriver, 3, "Teen", 0);
        ryanairPassenger3.enterPassengerTitle("Mr.");
        ryanairPassenger3.enterPassengerFirstName("Joshua Jr");
        ryanairPassenger3.enterPassengerLastName("Ola");

        Ryanair_Passenger ryanairPassenger4 = new Ryanair_Passenger(webDriver, 4, "Child", 0);
        ryanairPassenger4.enterPassengerTitle("Mr.");
        ryanairPassenger4.enterPassengerFirstName("Mark");
        ryanairPassenger4.enterPassengerLastName("Ola");

        webDriver.findElement(By.cssSelector(".continue-flow__button")).click();
        wait.until(ExpectedConditions.urlContains("https://www.ryanair.com/ie/en/trip/flights/seats"));
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertTrue(webDriver.getCurrentUrl().startsWith("https://www.ryanair.com/ie/en/trip/flights/seats"));

    }

    @Test
    public void seatSelectionTest(){

    }



    @AfterClass
    public void close(){
//        webDriver.close();
    }
}
