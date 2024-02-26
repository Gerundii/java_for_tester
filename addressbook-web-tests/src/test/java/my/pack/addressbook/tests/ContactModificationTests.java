package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHomePage();
        if (app.getContactHelper().getContactList().size() == 0) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(new ContactData("Willy", "Wonka", "WWnuggets@mail.ru", null));
        }
    }
    @Test (enabled = true)
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "somebody@mail.ru");
        app.getContactHelper().modifyCintact(index, before, contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<ContactData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
