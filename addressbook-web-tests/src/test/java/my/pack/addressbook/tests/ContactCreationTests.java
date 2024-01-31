package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().gotoContactCreatePage();
        app.getContactHelper().fillContactForm(ContactData.nibbler, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}
