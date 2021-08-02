package ru.stqa.stjv.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MNavigationHelper extends MHelperBase{
  public MNavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void configure() {

    click(By.linkText("управление"));
  }

  public void configureUsers() {

    click(By.linkText("управление"));
    click(By.linkText("Управление пользователями"));
  }

}
