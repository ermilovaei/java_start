package ru.stqa.stjv.mantis.appmanager;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.stqa.stjv.mantis.model.MailMassage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MMailHelper {
  private MApplicationManager app;
  private final Wiser wiser;

public MMailHelper (MApplicationManager app)
{
  this.app = app;
   wiser = new Wiser();
}

public List<MailMassage> waitForMail(int count, long timeout)
{
  long start = System.currentTimeMillis();
  while (System.currentTimeMillis() < start + timeout) {
    if (wiser.getMessages().size() >= count) {
      return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
    throw new Error("No mail");
  };

public static MailMassage toModelMail (WiserMessage m) {
  try {
    MimeMessage mm = m.getMimeMessage();
    return new MailMassage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
  } catch (MessagingException e) {
    e.printStackTrace();
    return null;
  } catch (IOException e) {
    e.printStackTrace();
    return null;
  }
}


public void start() {
  wiser.start();
}
  public void stop() {
    wiser.stop();
  }

}
