package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeleteTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.goTo().contactCreatePage();
            app.contact().create(new ContactData().withFirstname("Jamal").withLastname("Abdul").withEmail("nba45@yahoo.com"));
        }
    }
    @Test (enabled = true)
    public void testContactDelete() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(after, before);
    }
}
