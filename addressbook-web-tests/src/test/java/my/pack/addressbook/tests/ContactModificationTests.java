package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.nibbler);
        }
        app.getContactHelper().selectContact(before.size() - 2);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(ContactData.fry, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
