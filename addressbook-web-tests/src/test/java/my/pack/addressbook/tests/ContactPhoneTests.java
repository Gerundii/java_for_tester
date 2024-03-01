package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

    @Test (enabled = true)
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhonesPhone(), equalTo(mergedPhones(contactInfoFromEditForm)));
    }
    public String cleanedPhones(String phone) {
        return phone.replaceAll("[-()\\s]", "");
    }

    public String mergedPhones (ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter(s -> s != "")
                .map(s -> cleanedPhones(s))
                .collect(Collectors.joining("\n"));
    }
}
