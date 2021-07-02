package ru.stqa.stjv.adressbook.model;

import java.util.Objects;

public class contactData {
  private final int id;
  private final String lastName;
  private final String firstName;
  private final String adress;
  private final String emailFirst;
  private final String telephoneHome;
  private final String bDate;
  private final String bMonth;
  private final String bYear;



  public contactData(String lastName, String firstName, String adress, String emailFirst, String telephoneHome, String bDate, String bMonth, String bYear) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.adress = adress;
    this.telephoneHome = telephoneHome;
    this.emailFirst = emailFirst;
    this.bDate = bDate;
    this.bMonth = bMonth;
    this.bYear = bYear;
  }

  public contactData(String lastName, String firstName,  String adress, String emailFirst, String telephoneHome) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.adress = adress;
    this.telephoneHome = telephoneHome;
    this.emailFirst = emailFirst;
    this.bDate = "31";
    this.bMonth = "January";
    this.bYear = "1990";

  }

  public contactData(int id, String lastName, String firstName, String adress, String emailFirst, String telephoneHome) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.adress = adress;
    this.telephoneHome = telephoneHome;
    this.emailFirst = emailFirst;
    this.bDate = "31";
    this.bMonth = "January";
    this.bYear = "1990";
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
    return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(adress, that.adress) && Objects.equals(emailFirst, that.emailFirst) && Objects.equals(telephoneHome, that.telephoneHome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName, adress, emailFirst, telephoneHome);
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
