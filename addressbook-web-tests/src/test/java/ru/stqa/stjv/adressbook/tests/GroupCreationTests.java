package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupsPage();
    List<groupData> before = app.group().list();
    groupData group = new groupData("test group name", "test group header", "test group footer");
    app.group().create(group);

    List<groupData> after = app.group().list();

    Assert.assertEquals(after.size(),before.size() + 1);

    before.add(group);

    Comparator<? super groupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }

}



