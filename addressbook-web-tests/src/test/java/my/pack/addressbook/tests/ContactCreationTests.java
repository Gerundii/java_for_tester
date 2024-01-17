package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{
  @Test
  public void testContactCreation() throws Exception {

    for (ContactData contact: ContactData.contacts) {
      app.getNavigationHelper().gotoContactCreatePage();
      app.getContactHelper().fillContactForm(contact, true);
      app.getContactHelper().submitContactCreation();
      app.getContactHelper().returnToHomePage();
    }
  }
}
