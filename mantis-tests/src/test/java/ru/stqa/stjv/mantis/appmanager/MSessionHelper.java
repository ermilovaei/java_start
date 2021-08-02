package ru.stqa.stjv.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MSessionHelper extends MHelperBase {

  public MSessionHelper(WebDriver wd) {
    super(wd);
  }
  public void login(String userName, String password) {
    type(By.id("username"),userName);
    type(By.id("password"),password);
    click(By.xpath("//input[@value='Войти']"));
  }
}