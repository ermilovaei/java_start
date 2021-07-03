package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.ArrayList;
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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public void modify(int index, groupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupData(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(int index) {
    selectGroup(index);
    initGroupDeletion();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return
            isElementPresent(By.name("selected[]"));

  }

  public List<groupData> list() {
    List<groupData>  groups = new ArrayList<groupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("Span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new groupData().withId(id).withName(name));
    }
    return groups;
  }

  public Set<groupData> all() {
    Set<groupData> groups = new HashSet<groupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("Span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupData group = new groupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }

}
