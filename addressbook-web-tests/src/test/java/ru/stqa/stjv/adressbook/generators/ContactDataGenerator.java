package ru.stqa.stjv.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.stjv.adressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter (names = "-n", description = "Contacts count")
  public int count;
  @Parameter (names = "-f", description = "Target file")
  public String file;
  @Parameter (names = "-d", description = "DataFormat")
  public String format;


  public static void main(String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();

    JCommander jCommander = new JCommander(generator);
    try{
      jCommander.parse(args);
    } catch (ParameterException ex) {
      System.out.println(ex.getMessage());
      jCommander.usage();
      return;
    }

    generator.run();




  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);

    if (format.equals("csv")){
      saveAsCsv(contacts,new File(file));}
    else if (format.equals("json")){
      saveAsJson(contacts,new File(file));
    } else {
      System.out.println("Unrecognised format:" + format);
    }

  }




  private  List<ContactData> generateContacts(int count) {

    List<ContactData> contacts = new ArrayList<ContactData>();

    for (int i = 1; i <= count; i++){
      contacts.add(new ContactData().withFirstName(String.format("Contact Name %s", i))
              .withLastName(String.format("Last Name%s", i))
              .withAdress(String.format("Street %s, %s", i, i*10))
              .withBDate("28").withBMonth("April").withBYear("1980")
              .withEmailFirst(String.format("err%s@dd.tt", i))
              .withEmailSecond(String.format("email%s.Second@rrr.rr", i))
              .whithEmailThird(String.format("em_ai-l@Thi%s.rd", i))
              .withTelephoneHome("+7(234)54 44")
              .withTelephoneMobile(String.format("2323-232 2323.00%s",i))
              .withTelephoneWork("333.444#55").withTelephoneSecondaryHome("222 222 222")
              .withPhoto("src/test/resources/pic.png"));
    }
    return contacts;
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
                contact.getAdress()));
      }
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

}
