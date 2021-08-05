package ru.stqa.stjv.adressbook.tests;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.GroupData;
import ru.stqa.stjv.adressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GroupDeletionTests extends TestBase{
  private WebDriver wd;

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if (app.db().groups().size() == 0){
      app.group().create(new GroupData().withName("group name").withHeader("test group header").withFooter("test group footer"));
    }

  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();

    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));

    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withOut(deletedGroup )));
    verifyGroupListInUI();
  }


}



