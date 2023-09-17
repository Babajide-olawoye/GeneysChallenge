package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Ryanair_Passenger {
    private final WebDriver webDriver;
    private final String passengerType;
    private final int passengerNum;
    private final int typeNumber;
    private  By firstName;
    private By lastName;

    public Ryanair_Passenger(WebDriver driver, int passengerNum, String passengerType, int typeNumber) {
        this.webDriver = driver;
        this.passengerType = passengerType;
        this.passengerNum = passengerNum;
        this.typeNumber = typeNumber;

        setFirstName(passengerType);
        setLastName(passengerType);
    }

    public void enterPassengerTitle(String title){

        if(!this.passengerType.equalsIgnoreCase("Child")) {
            int place = 0;
            if (title.equalsIgnoreCase("Mr.")) {
                place = 1;
            } else if (title.equalsIgnoreCase("Mrs.")) {
                place = 2;
            } else if (title.equalsIgnoreCase("Ms.")) {
                place = 3;
            }


            webDriver.findElement(By.cssSelector("pax-passenger-container:nth-child(" + (passengerNum) + ") pax-passenger div pax-passenger-details-container pax-passenger-details pax-passenger-details-form-container pax-details-form ry-dropdown div:nth-child(2) button")).sendKeys(Keys.ENTER);
            webDriver.findElement(By.cssSelector("pax-passenger-container:nth-child(" + (passengerNum) + ") pax-passenger div pax-passenger-details-container pax-passenger-details pax-passenger-details-form-container pax-details-form ry-dropdown div:nth-child(2) ry-dropdown-item:nth-child(" + place + ")")).click();
        }
    }

    public void enterPassengerFirstName(String passengerFirstName) {
        webDriver.findElement(firstName).sendKeys(passengerFirstName);
    }
    public void enterPassengerLastName(String passengerLastName) {
        webDriver.findElement(lastName).sendKeys(passengerLastName);
    }


    public void setAdultFirstName(){
        this.firstName = By.id("form.passengers.ADT-"+typeNumber +".name");
    }
    public void setAdultLastName(){
        this.lastName = By.id("form.passengers.ADT-"+typeNumber +".surname");
    }

    public void setTeenFirstName(){
        this.firstName = By.id("form.passengers.TEEN-"+typeNumber +".name");
    }
    public void setTeenLastName(){
        this.lastName = By.id("form.passengers.TEEN-"+typeNumber +".surname");
    }
    public void setChildFirstName(){
        this.firstName = By.id("form.passengers.CHD-"+typeNumber +".name");
    }
    public void setChildLastName(){
        this.lastName = By.id("form.passengers.CHD-"+typeNumber +".surname");
    }

    public void setFirstName(String passengerType){
        if(passengerType.equalsIgnoreCase("ADULT")){
            setAdultFirstName();
        }
        else if(passengerType.equalsIgnoreCase("TEEN")){
            setTeenFirstName();
        }
        else{
            setChildFirstName();
        }
    }

    public void setLastName(String passengerType){
        if(passengerType.equalsIgnoreCase("ADULT")){
            setAdultLastName();
        }
        else if(passengerType.equalsIgnoreCase("TEEN")){
            setTeenLastName();
        }
        else{
            setChildLastName();
        }
    }


}
