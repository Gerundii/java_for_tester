package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailsTests extends TestBase{
    @Test (enabled = true)
    public void testContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        String result = mergedEmails(contactInfoFromEditForm);

        assertThat(contact.getAllEmails(), equalTo(mergedEmails(contactInfoFromEditForm)));
    }

    public String cleanedEmails (String email) {
        return email.replaceAll("-()\\s", "");
    }

    public String mergedEmails (ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream()
                .filter(s -> s != "")
                .map(s -> cleanedEmails(s))
                .collect(Collectors.joining("\n"));
    }
}
