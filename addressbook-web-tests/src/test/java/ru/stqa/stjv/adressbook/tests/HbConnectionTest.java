package ru.stqa.stjv.adressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.List;

public class HbConnectionTest
{

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }


  @Test (enabled = false)
  private void testHbConnectionGroups(){

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List <groupData> result = session.createQuery( "from GroupData" ).list();
    for ( groupData group : result ) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();

  }

  @Test
  private void testHbConnectionContacts(){

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List <ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00'" ).list();
    session.getTransaction().commit();
    session.close();
    for ( ContactData contact : result ) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }


  }

}
