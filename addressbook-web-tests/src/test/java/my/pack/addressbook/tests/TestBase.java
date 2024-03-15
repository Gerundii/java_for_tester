package my.pack.addressbook.tests;

import my.pack.addressbook.appmanager.ApplicationManager;
import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.Contacts;
import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    //public static ApplicationManager app = new ApplicationManager(Browser.FIREFOX.browserName());
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod (alwaysRun = true)
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map(group -> new GroupData()
                            .withId(group.getId())
                            .withName(group.getName()))
                    .collect(Collectors.toSet())));
        }
    }

    public void verifyContactsListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contact().all();
            assertThat(uiContacts, equalTo(dbContacts.stream()
                    .map(contact -> new ContactData()
                            .withId(contact.getId())
                            .withFirstname(contact.getFirstname())
                            .withLastname(contact.getLastname()))
                    .collect(Collectors.toSet())));
        }
    }
}
