package ru.stqa.stjv.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RestTests extends TestBase
{
  @Test
  public void testCreateIssue() throws IOException {

    skipIfNotFixed(2);

    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Iss EE").withDescription("EE");
    int issueID = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueID));
    Assert.assertEquals(newIssues, oldIssues);
}

  @Test
  public void testToRun() throws IOException {

    skipIfNotFixed(1272);

    System.out.println(findIssue(1272).getState_name());

  }

}
