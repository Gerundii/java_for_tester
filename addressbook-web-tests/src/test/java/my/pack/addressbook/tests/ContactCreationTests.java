package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.*;

import java.io.File;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    ContactData nibbler = new ContactData("Nibbler", "", "", "Nibbler", "Lord", "", "nibbler@futurama.com", "", "1", "August", "2000");
    ContactData fry = new ContactData("Phillip", "J", "Fry", "Fry", "Delivery Guy", "+982-265-265-22", "fry@futurama.com", "", "31", "December", "1999");
    app.getNavigationHelper().gotoContactCreatePage();
    app.getContactHelper().fillContactForm(nibbler);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.getNavigationHelper().gotoContactCreatePage();
    app.getContactHelper().fillContactForm(fry);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
