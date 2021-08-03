package ru.stqa.stjv.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.mantis.model.Issue;
import ru.stqa.stjv.mantis.model.Project;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends MTestBase
{
  @Test

  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(67);
Set<Project> projects = app.soap().getProjects();
Set<String> statuses;

    System.out.println(projects.size());
    for (Project pr: projects)
    {
      System.out.println(pr.getName());

    }

  }

  @Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(90);
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().
            withSummary("test I").withDescription("Test D").withProject(projects.iterator().next());
   Issue newIssue =  app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(), newIssue.getSummary());

  }




}
