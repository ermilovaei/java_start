package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
  app.getNavigationHelper().goToGroupsPage();
  app.getGroupHelper().selectGroup();
  app.getGroupHelper().initGroupModification();
  app.getGroupHelper().fillGroupData(new groupData("new name", "new header", "new footer"));
  app.getGroupHelper().submitGroupModification();
  app.getGroupHelper().returnToGroupPage();
  }

}
