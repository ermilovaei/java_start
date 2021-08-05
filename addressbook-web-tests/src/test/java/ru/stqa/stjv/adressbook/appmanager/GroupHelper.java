package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.GroupData;
import ru.stqa.stjv.adressbook.model.Groups;

import java.util.List;


public class GroupHelper extends HelperBase {

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  };

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }


  public void fillGroupData(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void initGroupDeletion() {
    click(By.name("delete"));
  }


  private void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']") ).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupData(group);
    submitGroupCreation();
    groupCash = null;
    returnToGroupPage();

  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupData(group);
    submitGroupModification();
    groupCash = null;
    returnToGroupPage();

  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    initGroupDeletion();
    groupCash = null;
    returnToGroupPage();

  }

  public boolean isThereAGroup() {
    return
            isElementPresent(By.name("selected[]"));

  }

  private Groups groupCash = null;

  public Groups all() {
    if (groupCash != null) {
      return new Groups(groupCash);
    }
    groupCash = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("Span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData().withId(id).withName(name);
      groupCash.add(group);
    }
    return new Groups(groupCash);
  }




}
