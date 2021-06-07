package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
  private  WebDriver wd;

  public SessionHelper(WebDriver wd) {
    this.wd = wd;
  }
  public void login(String userName, String password) {
    wd.get("http://localhost/addressbook/addressbook/index.php");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(userName);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }
}
