package ru.stqa.stjv.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.stjv.adressbook.model.GrouppData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter (names = "-n", description = "Groups count")
  public int count;
  @Parameter (names = "-f", description = "Target file")
  public String file;
  @Parameter (names = "-d", description = "DataFormat")
  public String format;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
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
    List<GrouppData> groups = generateGroups(count);

    if (format.equals("csv")){
    saveAsCsv(groups,new File(file));}
    else if (format.equals("json")){
    saveAsJson(groups,new File(file));
    } else {
      System.out.println("Unrecognised format:" + format);
    }

  }

  private  List<GrouppData> generateGroups(int count) {

    List<GrouppData> groups = new ArrayList<GrouppData>();
    for (int i = 1; i <= count; i++){
      groups.add(new GrouppData().withName(String.format("Group Name %s", i))
              .withFooter(String.format("Footer Name %s", i))
              .withHeader(String.format("Header Name %s", i)));
    }
    return groups;
  }

  private void saveAsCsv(List<GrouppData> groups, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (GrouppData group : groups) {
        writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
      }
    }
  }

  private void saveAsJson(List<GrouppData> groups, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(groups);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

}
