package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.ArrayList;
import java.util.List;

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

  public void createGroup(groupData group) {
    initGroupCreation();
    fillGroupData(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return
            isElementPresent(By.name("selected[]"));

  }

  public List<groupData> getGroupList() {
    List<groupData>  groups = new ArrayList<groupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("Span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      groupData group = new groupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}
