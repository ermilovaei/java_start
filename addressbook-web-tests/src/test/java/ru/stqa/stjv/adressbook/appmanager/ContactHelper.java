package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
     }

  public void fillContactData(contactData contactData) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("address"),contactData.getAdress());
    type(By.name("home"),contactData.getTelephoneHome());
    type(By.name("email"),contactData.getEmailFirst());

    dropDownChoice(By.name("bday"), contactData.getbDate());
    dropDownChoice(By.name("bmonth"), contactData.getbMonth());
    type(By.name("byear"),contactData.getbYear());

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}