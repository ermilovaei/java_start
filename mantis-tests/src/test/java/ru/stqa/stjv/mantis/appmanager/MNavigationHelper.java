package ru.stqa.stjv.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

  public void userPage (String userLogin) {

    click(By.linkText(userLogin));

  }


  public void resetPassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Изменить учетную запись']"));

  }
}
