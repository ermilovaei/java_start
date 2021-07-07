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
      String emailFirst = cells.get(4).getText();
      String telephoneHome= cells.get(5).getText();
      contactCash.add(new ContactData().withId(id).withLastName(lastName).withFirstName(firstName).
              withAdress(adress).withEmailFirst(emailFirst).withTelephoneHome(telephoneHome ));
    }
    return new Contacts(contactCash);
  }

}