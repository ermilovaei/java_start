package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
  app.getNavigationHelper().goToGroupsPage();
  if (! app.getGroupHelper().isThereAGroup()){
    app.getGroupHelper().createGroup(new groupData("test group name", "test group header", "test group footer"));
  }
  List<groupData> before = app.getGroupHelper().getGroupList();
  app.getGroupHelper().selectGroup(before.size() - 1);
  app.getGroupHelper().initGroupModification();
  groupData group = new groupData( before.get(before.size() - 1).getId(),"group", "test group header", "new group footer");
  app.getGroupHelper().fillGroupData(group);
  app.getGroupHelper().submitGroupModification();
  app.getGroupHelper().returnToGroupPage();
  List<groupData> after = app.getGroupHelper().getGroupList();

  Assert.assertEquals(after.size(),before.size());
    before.remove(before.size() - 1);
    before.add(group);
  Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

  }

}
