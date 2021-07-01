package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupsPage();
    List<groupData> before = app.getGroupHelper().getGroupList();
    groupData group = new groupData("test group name", "test group header", "test group footer");
    app.getGroupHelper().createGroup(group);
    List<groupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size() + 1);
    int max = 0;

    for (groupData g: after){
      if (g.getId()>max){
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<>(after),new HashSet<>(before));
  }

}



