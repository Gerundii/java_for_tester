package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactCreatePage();
        app.getContactHelper().fillContactForm(ContactData.fry, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
