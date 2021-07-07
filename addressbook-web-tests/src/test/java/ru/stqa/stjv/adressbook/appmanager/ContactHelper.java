package ru.stqa.stjv.adressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public boolean isThereAContact()
  {
    return
            isElementPresent(By.name("selected[]"));

  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactData(ContactData contactData) {
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


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']") ).click();

  }

  public void initContactDeletion() {

    click(By.xpath("//input[@value='Delete']"));
  }

  public void contactDeletionAlertAccept() {
    alertAccept();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']") ).click();
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contactData) {
   initContactCreation();
   fillContactData(contactData);
   submitContactCreation();
    contactCash = null;

  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
  fillContactData(contact);
  submitContactModification();
    contactCash = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    contactDeletionAlertAccept();
    contactCash = null;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCash = null;

  public Contacts all() {
    if (contactCash !=null) {
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> rows = wd.findElements(By.tagName("tr"));
    rows.remove(0);

    for (WebElement row:rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.name("selected[]")).getAttribute("id"));
      String  lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String adress = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allTelephones= cells.get(5).getText();
      contactCash.add(new ContactData().withId(id).withLastName(lastName).withFirstName(firstName)
              .withAdress(adress)
              .withAllEmails(allEmails)
              .withAllTelephones(allTelephones));
    }
    return new Contacts(contactCash);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("textContent");
    String emailFirst = wd.findElement(By.name("email")).getAttribute("value");
    String emailSecond = wd.findElement(By.name("email2")).getAttribute("value");
    String emailThird = wd.findElement(By.name("email3")).getAttribute("value");
    String telephoneHome = wd.findElement(By.name("home")).getAttribute("value");
    String telephoneMobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String telephoneWork = wd.findElement(By.name("work")).getAttribute("value");
    String telephoneSecondaryHome = wd.findElement(By.name("phone2")).getAttribute("value");
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName).withAdress(address)
            .withEmailFirst(emailFirst).withEmailSecond(emailSecond).whithEmailThird(emailThird)
            .withTelephoneHome(telephoneHome).withTelephoneMobile(telephoneMobile)
            .withTelephoneWork(telephoneWork).withTelephoneSecondaryHome(telephoneSecondaryHome);

  }
}