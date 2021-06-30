package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.stjv.adressbook.model.groupData;

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
}
