package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupData(new groupData("test group name", "test group header", "test group footer"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();

  }

}



