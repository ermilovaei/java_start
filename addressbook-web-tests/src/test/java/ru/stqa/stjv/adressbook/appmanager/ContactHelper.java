package ru.stqa.stjv.adressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void create(contactData contactData) {
   initContactCreation();
   fillContactData(contactData);
   submitContactCreation();

  }

  public void modify(contactData contact) {
    initContactModificationById(contact.getId());
  fillContactData(contact);
  submitContactModification();
  }

  public void delete(contactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    contactDeletionAlertAccept();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Set<contactData> all() {
    Set<contactData> contacts = new HashSet<contactData>();
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
      contacts.add(new contactData().withId(id).withLastName(lastName).withFirstName(firstName).
              withAdress(adress).withEmailFirst(emailFirst).withTelephoneHome(telephoneHome ));
    }
    return contacts;
  }

}