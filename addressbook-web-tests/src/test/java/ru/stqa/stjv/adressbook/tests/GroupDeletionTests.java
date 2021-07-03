package ru.stqa.stjv.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase{
  private WebDriver wd;

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if (app.group().all().size() == 0){
      app.group().create(new groupData().withName("group name").withHeader("test group header").withFooter("test group footer"));
    }

  }

  @Test
  public void testGroupDeletion() throws Exception {
    Set<groupData> before = app.group().all();
    int index = before.size() - 1;
    groupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);

    Set<groupData> after = app.group().all();

    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedGroup);
    Assert.assertEquals(after,before);

  }


}



