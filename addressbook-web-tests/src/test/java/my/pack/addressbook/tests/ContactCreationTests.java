package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {
    @Test (enabled = true)
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Yo").withLastname("Ma").withEmail("kafa@maza.su");
        app.goTo().contactCreatePage();
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
