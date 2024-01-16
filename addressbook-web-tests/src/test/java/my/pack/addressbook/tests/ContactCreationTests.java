package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;

public class ContactCreationTests extends TestBase{

  ContactData nibbler = new ContactData("Nibbler", "", "Ge", "Nibbler", "Lord", "", "nibbler@futurama.com", "", "1", "August", "2000", "testgroup");
  ContactData fry = new ContactData("Phillip", "J", "Fry", "Fry", "Delivery Guy", "+982-265-265-22", "fry@futurama.com", "", "31", "December", "1999", null);
  ContactData unknown = new ContactData("Unknown", "", "Man", "Unknown", "Somebody", "", "unknown@man.su", "", "13", "December", "1000", null);
  ContactData known = new ContactData("Known", "", "Man", "Unknown", "Somebody", "", "unknown@man.su", "", "13", "December", "1000", null);
  ArrayList<ContactData> contacts = new ArrayList<>();

  @Test
  public void testContactCreation() throws Exception {

    contacts.add(unknown);
    contacts.add(nibbler);
    contacts.add(fry);
    contacts.add(known);

    for (ContactData contact: contacts) {
      app.getNavigationHelper().gotoContactCreatePage();
      app.getContactHelper().fillContactForm(contact, true);
      app.getContactHelper().submitContactCreation();
      app.getContactHelper().returnToHomePage();
    }
  }
}
