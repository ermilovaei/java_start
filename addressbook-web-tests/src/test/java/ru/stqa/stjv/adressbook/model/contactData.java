package ru.stqa.stjv.adressbook.model;

import java.util.Objects;

public class contactData {
  private  int id = Integer.MAX_VALUE;
  private  String lastName;
  private  String firstName;
  private  String adress;
  private  String emailFirst;
  private  String telephoneHome;
  private  String bDate  = "31";
  private  String bMonth = "January";
  private  String bYear = "1990";


  public contactData withId(int id) {
    this.id = id;
    return this;
  }

  public  contactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public contactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public contactData withAdress(String adress) {
    this.adress = adress;
    return this;
  }

  public contactData withEmailFirst(String emailFirst) {
    this.emailFirst = emailFirst;
    return this;
  }

  public contactData withTelephoneHome(String telephoneHome) {
    this.telephoneHome = telephoneHome;
    return this;
  }

  public contactData withBDate(String bDate) {
    this.bDate = bDate;
    return this;
  }

  public contactData withBMonth(String bMonth) {
    this.bMonth = bMonth;
    return this;
  }

  public contactData withBYear(String bYear) {
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
    contactData that = (contactData) o;
    return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName);
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
