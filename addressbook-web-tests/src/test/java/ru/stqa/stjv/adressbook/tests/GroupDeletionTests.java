package ru.stqa.stjv.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.List;

public class GroupDeletionTests extends TestBase{
  private WebDriver wd;

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if (app.group().list().size() == 0){
      app.group().create(new groupData().withName("group name").withHeader("test group header").withFooter("test group footer"));
    }

  }

  @Test
  public void testGroupDeletion() throws Exception {
    List<groupData> before = app.group().list();
    int index = before.size() - 1;

    app.group().delete(index);

    List<groupData> after = app.group().list();

    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after,before);

  }


}



