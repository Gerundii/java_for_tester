package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isAnyContactExist()) {
            app.getNavigationHelper().gotoContactCreatePage();
            app.getContactHelper().createContact(ContactData.nibbler);
        }
        app.getContactHelper().selectContact(before.size() - 3);
        app.getContactHelper().initContactModification(before.get(before.size() - 3).getId());

        ContactData contact = new ContactData(before.get(before.size() - 3).getId(), "somebody@mail.ru");

        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 3);
        before.add(contact);
        Comparator<ContactData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
