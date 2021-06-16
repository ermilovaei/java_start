package ru.stqa.stjv.adressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTests extends TestBase{
  private WebDriver wd;


  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().goToGroupsPage();
    if (! app.getGroupHelper().isThereAGroup())
    { app.getGroupHelper().createGroup(new groupData("test group name", "test group header", "test group footer"));}
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupDeletion();
    app.getGroupHelper().returnToGroupPage();


  }

}



