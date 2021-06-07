package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {

    this.wd = wd;
  }

  public void returnToHomePage() {

    wd.findElement(By.linkText("home page")).click();
  }

  public void goToGroupsPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
