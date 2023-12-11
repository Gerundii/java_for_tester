package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactCreatePage();
    app.getContactHelper().fillContactForm(new ContactData("John", "Young", "Oshee", "ladboy", "Senior", "6527853951", "wowcoolguy@yahoo.com", "coolguy.net", "8", "August", "2000"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.getSessionHelper().logout();
  }
}
