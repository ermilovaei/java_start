package ru.stqa.stjv.adressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name ="group_list")
public class GrouppData {
  @Id
  @Column  (name ="group_id")
  private int id = Integer.MAX_VALUE;;
  @Expose
  @Column  (name ="group_name")
  private  String name;
  @Expose
  @Column  (name ="group_header")
  @Type(type = "text")
  private  String header;
  @Expose
  @Column  (name ="group_footer")
  @Type(type = "text")
  private  String footer;
  @ManyToMany (mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  public GrouppData withId(int id) {
    this.id = id;
    return this;
  }

  public GrouppData withName(String name) {
    this.name = name;
    return this;
  }

  public GrouppData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GrouppData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GrouppData groupData = (GrouppData) o;
    return id == groupData.id && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, header, footer);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "groupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            '}';
  }

}
