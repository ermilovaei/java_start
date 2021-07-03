package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void HomePageBack() {

    click(By.linkText("home page"));
  }

  public void GroupsPage() {

    click(By.linkText("groups"));
  }
  public void ContactsPage() {

    click(By.linkText("home"));
  }


}
