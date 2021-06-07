package ru.stqa.stjv.adressbook.model;

public class contactData {
  private final String firstName;
  private final String lastName;
  private final String adress;
  private final String telephoneHome;
  private final String emailFirst;
  private final String bDate;
  private final String bMonth;
  private final String bYear;

  public contactData(String firstName, String lastName, String Adress, String telephoneHome, String emailFirst, String bDate, String bMonth, String bYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    adress = Adress;
    this.telephoneHome = telephoneHome;
    this.emailFirst = emailFirst;
    this.bDate = bDate;
    this.bMonth = bMonth;
    this.bYear = bYear;
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
