package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if (app.group().list().size() == 0){
      app.group().create(new groupData("group name", "test group header", "test group footer"));
    }

  }

  @Test
  public void testGroupModification(){

  List<groupData> before = app.group().list();
  int index = before.size() - 1;
  groupData group = new groupData( before.get(index).getId(),"new group", "test group header", "new group footer");

  app.group().modify(index, group);

  List<groupData> after = app.group().list();

  Assert.assertEquals(after.size(),before.size());
    before.remove(index);
    before.add(group);
    Comparator<? super groupData> byID = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
  Assert.assertEquals(before, after);

  }



}
