package ru.stqa.stjv.adressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;
import ru.stqa.stjv.adressbook.tests.ContactDataTests;

import javax.persistence.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name ="addressbook")
public class ContactData {
  @Id
  @Column(name ="id")
  private  int id = Integer.MAX_VALUE;
  @Expose
  @Column(name ="lastName")
  private  String lastName;
  @Expose
  @Column(name ="firstName")
  private  String firstName;
  @Expose
  @Column(name ="address")
  @Type(type = "text")
  private  String adress;
  @Expose
  @Column(name ="email")
  @Type(type = "text")
  private  String emailFirst;
  @Expose
  @Column(name ="email2")
  @Type(type = "text")
  private  String emailSecond;
  @Expose
  @Column(name ="email3")
  @Type(type = "text")
  private  String emailThird;

  @Transient
  private  String allEmails;
  @Transient
  private  String allTelephones;

  @Expose
  @Column(name ="home")
  @Type(type = "text")
  private  String telephoneHome;

  @Expose
  @Column(name ="mobile")
  @Type(type = "text")
  private  String telephoneMobile;

  @Expose
  @Column(name ="work")
  @Type(type = "text")
  private  String telephoneWork;

  @Expose
  @Column(name ="phone2")
  @Type(type = "text")
  private  String telephoneSecondaryHome;

  @Expose
  @Column(name ="bday")
  @Type(type = "byte")
  private  byte bDate  = 31;

  @Expose
  @Column(name ="bmonth")
  private  String bMonth = "January";

  @Expose
  @Column(name ="byear")
  private  String bYear = "1990";

  @Expose
  @Column(name ="photo")
  @Type(type = "text")
  private String photo = "src/test/resources/pic.png";

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable (name ="address_in_groups",
          joinColumns = @JoinColumn (name="id"),
          inverseJoinColumns = @JoinColumn (name = "group_id"))
  private Set<groupData> groups = new HashSet<groupData>();

  public Groups getGroups() {
    return new  Groups(groups);
  }

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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
    this.bDate = Byte.parseByte(bDate);
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
    return "ContactData{" +
            "id=" + id +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", adress='" + adress + '\'' +
            ", emailFirst='" + emailFirst + '\'' +
            ", emailSecond='" + emailSecond + '\'' +
            ", emailThird='" + emailThird + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", allTelephones='" + allTelephones + '\'' +
            ", telephoneHome='" + telephoneHome + '\'' +
            ", telephoneMobile='" + telephoneMobile + '\'' +
            ", telephoneWork='" + telephoneWork + '\'' +
            ", telephoneSecondaryHome='" + telephoneSecondaryHome + '\'' +
            ", bDate=" + bDate +
            ", bMonth='" + bMonth + '\'' +
            ", bYear='" + bYear + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && bDate == that.bDate && Objects.equals(lastName, that.lastName)
            && Objects.equals(firstName, that.firstName) && Objects.equals(adress, that.adress)
            && Objects.equals(emailFirst, that.emailFirst) && Objects.equals(emailSecond, that.emailSecond)
            && Objects.equals(emailThird, that.emailThird) && Objects.equals(telephoneHome, that.telephoneHome)
            && Objects.equals(telephoneMobile, that.telephoneMobile) && Objects.equals(telephoneWork, that.telephoneWork)
            && Objects.equals(telephoneSecondaryHome, that.telephoneSecondaryHome) && Objects.equals(bMonth, that.bMonth)
            && Objects.equals(bYear, that.bYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, firstName, adress, emailFirst, emailSecond, emailThird, telephoneHome, telephoneMobile, telephoneWork, telephoneSecondaryHome, bDate, bMonth, bYear);
  }



  public String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getTelephoneHome(),
            contact.getTelephoneMobile(),
            contact.getTelephoneWork(),
            contact.getTelephoneSecondaryHome())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDataTests::clened)
            .collect(Collectors.joining("\n"));
  }

  public String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmailFirst(),
            contact.getEmailSecond(),
            contact.getEmailThird())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
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
    return Byte.toString(bDate);
  }

  public String getbMonth() {
    return bMonth;
  }

  public String getbYear() {
    return bYear;
  }



}
