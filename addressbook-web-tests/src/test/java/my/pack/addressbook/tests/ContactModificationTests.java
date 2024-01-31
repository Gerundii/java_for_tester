package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactModification() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.nibbler);
        }
        app.getContactHelper().selectContact(before - 2);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(ContactData.fry, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
