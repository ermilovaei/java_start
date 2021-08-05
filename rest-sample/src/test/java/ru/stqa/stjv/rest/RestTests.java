package ru.stqa.stjv.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class RestTests
{
  @Test
  public void createIssue(){
    Set<Issure> oldIssues = getIssures();
    Issure newIssue = new Issure();
    int issureID = createIssure(newIssue);
    Set<Issure> newIssues = getIssures();
    oldIssues.add(newIssue.withId(issureID));
    Assert.assertEquals(newIssues, oldIssues);
}

  private Set<Issure> getIssures() {
    return null;
  }
}
