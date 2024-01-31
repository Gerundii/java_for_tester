package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeleteTests extends TestBase{
    @Test
    public void testContactDelete() {
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.fry);
        }
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDelete();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }
}
