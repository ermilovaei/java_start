package ru.stqa.stjv.adressbook.model;

import java.util.Objects;

public class groupData {
  private int id = Integer.MAX_VALUE;;
  private  String name;
  private  String header;
  private  String footer;


  public groupData withId(int id) {
    this.id = id;
    return this;
  }

  public groupData withName(String name) {
    this.name = name;
    return this;
  }

  public groupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public groupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }





  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    groupData groupData = (groupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
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
