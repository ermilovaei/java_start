package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
  app.getNavigationHelper().goToGroupsPage();
  if (! app.getGroupHelper().isThereAGroup()){
    app.getGroupHelper().createGroup(new groupData("test group name", "test group header", "test group footer"));
  }
  app.getGroupHelper().selectGroup();
  app.getGroupHelper().initGroupModification();
  app.getGroupHelper().fillGroupData(new groupData(null, "test group header", "new group footer"));
  app.getGroupHelper().submitGroupModification();
  app.getGroupHelper().returnToGroupPage();
  }

}
