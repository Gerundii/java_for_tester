package my.pack.addressbook.appmanager;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.Contacts;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());
        /*try {
            select(By.name("new_group"), contactData.getGroup());
        } catch (NoSuchElementException e) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }*/
        if (creation) {
            select(By.name("new_group"), contactData.getGroup());
        } else Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void selectContactById(int id) {
        String selectXpath = String.format("//input[@id='%d']", id);
        click(By.xpath(selectXpath));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDelete() {
        acceptAlert();
    }

    public void initContactModificationById(int id) {
        String initXpath = String.format("//a[@href='edit.php?id=%d']", id);
        click(By.xpath(initXpath));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact) {
        fillContactForm(contact, true);
        submitContactCreation();
        contactsCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactsCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        submitContactDelete();
        contactsCache = null;
    }

    public boolean isAnyContactExist() {
        return isElementPresent(By.name("selected[]"));
    }
    public int count() {
        return wd.findElements(By.name("entry")).size();
    }

    private Contacts contactsCache = null;
    public Contacts all() {
        if (contactsCache != null) {
            return new Contacts(contactsCache);
        }
        contactsCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements((By.tagName("td")));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String email = cells.get(4).getText();
            String allphones = cells.get(5).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withEmail(email).withAllPhones(allphones);
            contactsCache.add(contact);
        }
        return new Contacts(contactsCache);
    }

    public ContactData infoFromEditForm (ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
