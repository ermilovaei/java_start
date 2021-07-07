package ru.stqa.stjv.adressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id = Integer.MAX_VALUE;
  private  String lastName;
  private  String firstName;
  private  String adress;
  private  String emailFirst;
  private  String emailSecond;
  private  String emailThird;

  private  String allEmails;
  private  String allTelephones;

  private  String telephoneHome;
  private  String telephoneMobile;
  private  String telephoneWork;
  private  String telephoneSecondaryHome;

  private  String bDate  = "31";
  private  String bMonth = "January";
  private  String bYear = "1990";

  public String getAllTelephones() {
    return allTelephones;
  }

  public ContactData withAllTelephones(String allTelephones) {
    this.allTelephones = allTelephones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getEmailSecond() {
    return emailSecond;
  }

  public ContactData withEmailSecond(String emailSecond) {
    this.emailSecond = emailSecond;
    return this;
  }

  public String getEmailThird() {
    return emailThird;
  }

  public ContactData whithEmailThird(String emailThird) {
    this.emailThird = emailThird;
    return this;
  }

  public String getTelephoneMobile() {
    return telephoneMobile;
  }

  public ContactData withTelephoneMobile(String telephoneMobile) {
    this.telephoneMobile = telephoneMobile;
    return this;
  }

  public String getTelephoneWork() {
    return telephoneWork;
  }

  public ContactData withTelephoneWork(String telephoneWork) {
    this.telephoneWork = telephoneWork;
    return this;
  }

  public String getTelephoneSecondaryHome() {
    return telephoneSecondaryHome;
  }

  public ContactData withTelephoneSecondaryHome(String telephoneSecondaryHome) {
    this.telephoneSecondaryHome = telephoneSecondaryHome;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withAdress(String adress) {
    this.adress = adress;
    return this;
  }

  public ContactData withEmailFirst(String emailFirst) {
    this.emailFirst = emailFirst;
    return this;
  }

  public ContactData withTelephoneHome(String telephoneHome) {
    this.telephoneHome = telephoneHome;
    return this;
  }

  public ContactData withBDate(String bDate) {
    this.bDate = bDate;
    return this;
  }

  public ContactData withBMonth(String bMonth) {
    this.bMonth = bMonth;
    return this;
  }

  public ContactData withBYear(String bYear) {
    this.bYear = bYear;
    return this;
  }

  @Override
  public String toString() {
    return "contactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", adress='" + adress + '\'' +
            ", telephoneHome='" + telephoneHome + '\'' +
            ", emailFirst='" + emailFirst + '\'' +
            ", bDate='" + bDate + '\'' +
            ", bMonth='" + bMonth + '\'' +
            ", bYear='" + bYear + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, firstName);
  }

  public int getId() {
    return id;
  }
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAdress() {
    return adress;
  }

  public String getTelephoneHome() {
    return telephoneHome;
  }

  public String getEmailFirst() {
    return emailFirst;
  }

  public String getbDate() {
    return bDate;
  }

  public String getbMonth() {
    return bMonth;
  }

  public String getbYear() {
    return bYear;
  }


}
