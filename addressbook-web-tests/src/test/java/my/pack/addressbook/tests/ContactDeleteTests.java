package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase{
    @Test
    public void testContactDelete() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.fry);
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDelete();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
