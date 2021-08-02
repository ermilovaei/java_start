package ru.stqa.stjv.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class MAdminHelper extends MHelperBase{
  public MAdminHelper(WebDriver wd) {
    super(wd);
  }

  public String randomUserLogin () {
    List<WebElement> rows = wd.findElements(By.tagName("tr"));

    String linkText = "administrator";

    while (linkText.equals("administrator")) {
      Random random = new Random();
      int rowIndex = random.nextInt(rows.size());
      List<WebElement> cells = rows.get(rowIndex).findElements(By.tagName("td"));
      linkText = cells.get(0).getText();
    }
   return linkText;

  }


  public void resetPassword() {

    click(By.xpath("//input[@value='Сбросить пароль']"));

  }


}
