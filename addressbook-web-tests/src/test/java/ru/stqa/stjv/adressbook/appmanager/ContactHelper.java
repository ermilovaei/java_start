package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactHelper extends HelperBase {

  public boolean isThereAContact()
  {
    return
            isElementPresent(By.name("selected[]"));

  }

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactData(contactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAdress());
    type(By.name("home"), contactData.getTelephoneHome());
    type(By.name("email"), contactData.getEmailFirst());

    dropDownChoice(By.name("bday"), contactData.getbDate());
    dropDownChoice(By.name("bmonth"), contactData.getbMonth());
    type(By.name("byear"), contactData.getbYear());

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void contactDeletionAlertAccept() {
    alertAccept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(contactData contactData) {
   initContactCreation();
   fillContactData(contactData);
   submitContactCreation();

  }
}