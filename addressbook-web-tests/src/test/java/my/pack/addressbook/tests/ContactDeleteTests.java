package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeleteTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHomePage();
        if (app.getContactHelper().getContactList().size() == 0) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.nibbler);
        }
    }
    @Test (enabled = true)
    public void testContactDelete() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDelete();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(after, before);
    }
}
