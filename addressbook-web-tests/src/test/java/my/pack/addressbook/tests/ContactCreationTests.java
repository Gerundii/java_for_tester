package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;

public class ContactCreationTests extends TestBase{

  ContactData nibbler = new ContactData("Nibbler", "", "", "Nibbler", "Lord", "", "nibbler@futurama.com", "", "1", "August", "2000");
  ContactData fry = new ContactData("Phillip", "J", "Fry", "Fry", "Delivery Guy", "+982-265-265-22", "fry@futurama.com", "", "31", "December", "1999");
  ContactData unknown = new ContactData("Unknown", "", "Man", "Unknown", "Somebody", "", "unknown@man.su", "", "13", "December", "1000");
  ArrayList<ContactData> contacts = new ArrayList<>();

  @Test
  public void testContactCreation() throws Exception {

    contacts.add(nibbler);
    contacts.add(fry);
    contacts.add(unknown);

    for (ContactData contact: contacts) {
      app.getNavigationHelper().gotoContactCreatePage();
      app.getContactHelper().fillContactForm(contact);
      app.getContactHelper().submitContactCreation();
      app.getContactHelper().returnToHomePage();
    }
  }
}
