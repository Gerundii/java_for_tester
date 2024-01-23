package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
    //ContactData known = new ContactData("Known", "", "Man", "Unknown", "Somebody", "", "unknown@man.su", "", "13", "December", "1000", null);

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.fry);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(ContactData.known, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
