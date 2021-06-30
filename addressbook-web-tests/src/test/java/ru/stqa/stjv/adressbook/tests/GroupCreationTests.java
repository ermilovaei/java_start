package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupsPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new groupData("test group name", "test group header", "test group footer"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before + 1);
  }

}



