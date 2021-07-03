package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupsPage();
    Set<groupData> before = app.group().all();
    groupData group = new groupData("test group name", "test group header", "test group footer");
    app.group().create(group);

    Set<groupData> after = app.group().all();

    Assert.assertEquals(after.size(),before.size() + 1);

    app.group().withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);

    Assert.assertEquals(before, after);
  }

}



