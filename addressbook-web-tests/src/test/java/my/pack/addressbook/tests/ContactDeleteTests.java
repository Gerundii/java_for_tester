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
            app.getContactHelper().createContact(new ContactData("Jamal", "Abdul", "nba45@yahoo.com", null));
        }
    }
    @Test (enabled = true)
    public void testContactDelete() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().deleteContact(index);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(after, before);
    }
}
