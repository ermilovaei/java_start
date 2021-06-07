package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final GroupHelper groupHelper = new GroupHelper();

  public void init() {
    groupHelper.wd = new FirefoxDriver();
    groupHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login();
  }

  public void returnToHomePage() {

    groupHelper.wd.findElement(By.linkText("home page")).click();
  }

  public void submitContactCreation() {

    groupHelper.wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactData(contactData contactData) {
    groupHelper.wd.findElement(By.name("firstname")).click();
    groupHelper.wd.findElement(By.name("firstname")).clear();
    groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    groupHelper.wd.findElement(By.name("lastname")).click();
    groupHelper.wd.findElement(By.name("lastname")).clear();
    groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    groupHelper.wd.findElement(By.name("address")).click();
    groupHelper.wd.findElement(By.name("address")).clear();
    groupHelper.wd.findElement(By.name("address")).sendKeys(contactData.getAdress());
    groupHelper.wd.findElement(By.name("home")).click();
    groupHelper.wd.findElement(By.name("home")).clear();
    groupHelper.wd.findElement(By.name("home")).sendKeys(contactData.getTelephoneHome());
    groupHelper.wd.findElement(By.name("email")).click();
    groupHelper.wd.findElement(By.name("email")).clear();
    groupHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmailFirst());
    groupHelper.wd.findElement(By.name("bday")).click();
    new Select(groupHelper.wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getbDate());
    groupHelper.wd.findElement(By.name("bday")).click();
    groupHelper.wd.findElement(By.name("bmonth")).click();
    new Select(groupHelper.wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getbMonth());
    groupHelper.wd.findElement(By.name("bmonth")).click();
    groupHelper.wd.findElement(By.name("byear")).click();
    groupHelper.wd.findElement(By.name("byear")).clear();
    groupHelper.wd.findElement(By.name("byear")).sendKeys(contactData.getbYear());
  }

  public void initContactCreation() {

    groupHelper.wd.findElement(By.linkText("add new")).click();
  }

  private void login() {
    groupHelper.wd.get("http://localhost/addressbook/addressbook/index.php");
    groupHelper.wd.findElement(By.name("user")).clear();
    groupHelper.wd.findElement(By.name("user")).sendKeys("admin");
    groupHelper.wd.findElement(By.name("pass")).click();
    groupHelper.wd.findElement(By.name("pass")).clear();
    groupHelper.wd.findElement(By.name("pass")).sendKeys("secret");
    groupHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void stop() {
    groupHelper.wd.quit();
  }

  public void goToGroupsPage() {
    groupHelper.wd.findElement(By.linkText("groups")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      groupHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      groupHelper.wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
