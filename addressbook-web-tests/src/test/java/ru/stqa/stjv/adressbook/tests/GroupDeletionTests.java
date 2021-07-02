package ru.stqa.stjv.adressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupDeletionTests extends TestBase{
  private WebDriver wd;

  @BeforeMethod
  private void ensurePreconditions() {
    app.getNavigationHelper().goToGroupsPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new groupData("group name", "test group header", "test group footer"));
    }

  }

  @Test
  public void testGroupDeletion() throws Exception {
    List<groupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupDeletion();
    app.getGroupHelper().returnToGroupPage();
    List<groupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(),before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(after,before);

  }

}



