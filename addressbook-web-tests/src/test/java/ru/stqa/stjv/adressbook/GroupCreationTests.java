package ru.stqa.stjv.adressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    goToGroupsPage();
    initGroupCreation();
    fillGroupData(new groupData("test group name", "test group header", "test group footer"));
    submitGroupCreation();
    returnToGroupPage();

  }

}



