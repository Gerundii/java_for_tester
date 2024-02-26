package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactCreatePage();

        ContactData contact = new ContactData("Yo", "", "Ma", "Za", "Faka", "", "kafa@maza.su", "", "13", "December", "1000", null);

        app.getContactHelper().fillContactForm(contact, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        Comparator<ContactData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

        int max = after.stream().max(byId).get().getId();

        contact.setId(max);
        before.add(contact);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
