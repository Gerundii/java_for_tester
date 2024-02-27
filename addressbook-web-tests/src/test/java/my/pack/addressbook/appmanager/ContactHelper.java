package my.pack.addressbook.appmanager;

import my.pack.addressbook.model.ContactData;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        wd.findElement(By.xpath("//input[@id='" + id + "']")).click();
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

    public void create(ContactData contact) {
        fillContactForm(contact, true);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModification(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        submitContactDelete();
    }

    public boolean isAnyContactExist() {
        return isElementPresent(By.name("selected[]"));
    }
    public int getContactCount() {
        return wd.findElements(By.name("entry")).size();
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
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
