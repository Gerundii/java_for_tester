package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test (enabled = true)
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstname("Yo").withLastname("Ma").withEmail("kafa@maza.su");
        app.goTo().contactCreatePage();
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<ContactData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
