package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public int getGroupCount() {
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


  public void fillGroupData(groupData groupData) {
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

  public void create(groupData group) {
    initGroupCreation();
    fillGroupData(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(groupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupData(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(groupData group) {
    selectGroupById(group.getId());
    initGroupDeletion();
    returnToGroupPage();

  }

  public boolean isThereAGroup() {
    return
            isElementPresent(By.name("selected[]"));

  }


  public Set<groupData> all() {
    Set<groupData> groups = new HashSet<groupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("Span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupData group = new groupData().withId(id).withName(name);
      groups.add(group);
    }
    return groups;
  }




}
