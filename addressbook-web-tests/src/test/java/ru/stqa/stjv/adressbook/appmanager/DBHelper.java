package ru.stqa.stjv.adressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;
import ru.stqa.stjv.adressbook.model.GroupData;
import ru.stqa.stjv.adressbook.model.Groups;

import java.util.List;

public class DBHelper {

  private final SessionFactory sessionFactory;

  public DBHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List <GroupData> result = session.createQuery( "from GroupData" ).list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List <ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00 00:00:00'" ).list();
    session.getTransaction().commit();
    session.close();
    System.out.println(result);
    Contacts contacts = new Contacts(result);
    System.out.println(contacts);
    return new Contacts(result);
  }

}
