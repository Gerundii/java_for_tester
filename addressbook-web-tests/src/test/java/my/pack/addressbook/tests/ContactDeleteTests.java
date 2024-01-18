package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase{
    @Test
    public void testContactDelete() {
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getContactHelper().createContact(ContactData.fry);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDelete();
        app.getNavigationHelper().gotoHomePage();
    }
}
