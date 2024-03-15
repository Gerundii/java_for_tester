package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactCreatePage();
            app.contact().create(new ContactData()
                    .withFirstname("Willy")
                    .withLastname("Wonka")
                    .withEmail("WWnuggets@mail.ru"));
        }
    }
    @Test (enabled = true)
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstname(modifiedContact.getFirstname())
                .withLastname(modifiedContact.getLastname())
                .withEmail("somebody@mail.ru")
                .withEmail2(modifiedContact.getEmail2())
                .withEmail3(modifiedContact.getEmail3())
                .withHomePhone(modifiedContact.getHomePhone())
                .withMobilePhone(modifiedContact.getMobilePhone())
                .withWorkPhone(modifiedContact.getWorkPhone());
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        verifyContactsListInUI();
    }
}
