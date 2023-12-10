package my.pack.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    gotoContactCreatePage();
    fillContactForm(new ContactData("John", "Young", "Oshee", "ladboy", "Senior", "6527853951", "wowcoolguy@yahoo.com", "coolguy.net", "8", "August", "2000"));
    submitContactCreation();
    returnToHomePage();
    logout();
  }
}
