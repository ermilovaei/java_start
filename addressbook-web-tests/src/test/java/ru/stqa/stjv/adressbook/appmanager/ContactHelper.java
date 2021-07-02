package ru.stqa.stjv.adressbook.appmanager;

import io.netty.handler.codec.http.websocketx.WebSocket13FrameEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.ArrayList;
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactDeletion() {

    click(By.xpath("//input[@value='Delete']"));
  }

  public void contactDeletionAlertAccept() {
    alertAccept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(contactData contactData) {
   initContactCreation();
   fillContactData(contactData);
   submitContactCreation();

  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<contactData> getContactList() {
    List<contactData> contacts = new ArrayList<contactData>();
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
      contacts.add(new contactData(id,lastName, firstName, adress, emailFirst, telephoneHome ));
    }
    return contacts;
  }
}