package my.pack.addressbook.appmanager;

import my.pack.addressbook.model.ContactData;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;
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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDelete() {
        acceptAlert();
    }

    public void initContactModification(int id) {
        String initXpath = "//a[@href='edit.php?id=" + id + "']";
        click(By.xpath(initXpath));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isAnyContactExist() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        fillContactForm(contact, true);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(int index, List<ContactData> before, ContactData contact) {
        selectContact(index);
        initContactModification(before.get(index).getId());
        fillContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        submitContactDelete();
    }
    public int getContactCount() {
        return wd.findElements(By.name("entry")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//input[@name='selected[]']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.getAttribute("id"));
            String email = element.getAttribute("accept");
            ContactData contact = new ContactData().withId(id).withEmail(email);
            contacts.add(contact);
        }
        return contacts;
    }
}
