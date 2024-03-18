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
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        attach(By.name("photo"), contactData.getPhoto());
        /*try {
            select(By.name("new_group"), contactData.getGroup());
        } catch (NoSuchElementException e) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }*/
        if (creation) {
            //Из множества групп объекта класса ContactData выбираем одну, берем ее имя и выбираем эту группу в интерфейсе при создании контакта
            select(By.name("new_group"), contactData.getGroups().iterator().next().getName());
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
            String allEmails = cells.get(4).getText();
            String allphones = cells.get(5).getText();
            ContactData contact = new ContactData()
                    .withId(id)
                    .withFirstname(firstname).withLastname(lastname)
                    .withAllEmails(allEmails)
                    .withAllPhones(allphones);
            contactsCache.add(contact);
        }
        return new Contacts(contactsCache);
    }

    public ContactData infoFromEditForm (ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = getValue(By.name("firstname"));
        String lastname = getValue(By.name("lastname"));
        String email = getValue(By.name("email"));
        String email2 = getValue(By.name("email2"));
        String email3 = getValue(By.name("email3"));
        String home = getValue(By.name("home"));
        String mobile = getValue(By.name("mobile"));
        String work = getValue(By.name("work"));
        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId())
                .withFirstname(firstname).withLastname(lastname)
                .withEmail(email).withEmail2(email2).withEmail3(email3)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
