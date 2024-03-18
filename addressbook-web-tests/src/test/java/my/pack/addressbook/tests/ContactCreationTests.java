package my.pack.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.Contacts;
import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContactsCsv() throws IOException {
        List<Object[]> contacts = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                contacts.add(new Object[] {new ContactData().withFirstname(split[0])
                        .withLastname(split[1])
                        .withPhoto(split[2])
                        .withEmail(split[3])});
                line = reader.readLine();
            }
        }
        return contacts.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validContactsJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType()); // List<ContactData>.class
            return contacts.stream().map(g -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("Big")
                    .withHeader("Bang")
                    .withFooter("Boom"));
        }
    }
    @Test (enabled = true, dataProvider = "validContactsJson")
    public void testContactCreation(ContactData contact) throws Exception {
        //Получаем список групп из БД
        Groups groups = app.db().groups();
        //Добавляем к объекту класса ContactData любую группу из БД
        contact.inGroup(groups.iterator().next());
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.goTo().contactCreatePage();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt()))));

        verifyContactsListInUI();
    }
}
