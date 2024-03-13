package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.Contacts;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContactsCsv() throws IOException {
        List<Object[]> contacts = new ArrayList<Object[]>();
        File photo = new File("./src/test/resources/default.jpg");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                contacts.add(new Object[] {new ContactData().withFirstname(split[0])
                        .withLastname(split[1])
                        .withPhoto(photo)
                        .withEmail(split[2])});
                line = reader.readLine();
            }
        }
        return contacts.iterator();
    }
    @Test (enabled = true, dataProvider = "validContactsCsv")
    public void testContactCreation(ContactData contact) throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        //ContactData contact = new ContactData().withFirstname("Bzezhik").withLastname("Kshishtof").withPhoto(photo).withEmail("oleiUp@example.com");
        app.goTo().contactCreatePage();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt()))));

    }
}
