package ru.stqa.stjv.adressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GrouppData> {
  private Set<GrouppData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GrouppData>(groups.delegate) ;

  }

  public Groups() {
    this.delegate = new HashSet<GrouppData>();
  }

  public Groups(Collection<GrouppData> groups) {
    this.delegate = new HashSet<GrouppData>(groups) ;
  }

  @Override
  protected Set<GrouppData> delegate() {
    return delegate;
  }
  public Groups withAdded(GrouppData group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }
  public Groups withOut(GrouppData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

}
