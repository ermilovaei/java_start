package ru.stqa.stjv.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.stjv.mantis.model.Issue;
import ru.stqa.stjv.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {
  private MApplicationManager app;

  public SoapHelper  (MApplicationManager app) {
    this.app = app;
  }

public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
  MantisConnectPortType mc = getMantisConnect();
  ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator","123");
  return Arrays.asList(projects).stream().
          map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName())).collect(Collectors.toSet());
}

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    String webService = app.getProperties().getProperty("web.pmsConnect", "http://localhost/mantisbt-2.25.2/mantisbt-2.25.2/api/soap/mantisconnect.php");

    MantisConnectPortType mc = new MantisConnectLocator()
            .getMantisConnectPort(new
                    URL(webService));
    return mc;
  }

  public String getIssueStatus(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    IssueData issueData = mc.mc_issue_get("administrator","123", BigInteger.valueOf(issueId));
    return issueData.getStatus().getName();

  };

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories("administrator","123",
            (BigInteger.valueOf(issue.getProject().getId())));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()),
            issue.getProject().getName() ));
    issueData.setCategory(categories[0]);

    BigInteger issueID  = mc.mc_issue_add("administrator","123", issueData);
    IssueData newIssueData = mc.mc_issue_get("administrator","123", issueID);
    return new Issue().withId(newIssueData.getId().intValue())
            .withSummary(newIssueData.getSummary()).withDescription(newIssueData.getDescription())
            .withProject(new Project().withId(newIssueData.getProject().getId().intValue())
                          .withName(newIssueData.getProject().getName()));

  }
}
