package my.pack.addressbook.appmanager;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.GroupData;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    private final String defaultPhotoPath = (new File("./src/test/resources/default.jpg").getAbsolutePath());

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        try {
            addImg(By.xpath("//input[@type='file']"), contactData.getPhotoPath());
        } catch (InvalidArgumentException e) {
            addImg(By.xpath("//input[@type='file']"), contactData.getDefaultPhotoPath());
        }
        type(By.name("title"), contactData.getTitle());
        type(By.name("mobile"), contactData.getMobileTelephone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
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

    public void initContactModification() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isAnyContactExist() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        fillContactForm(contact, true);
        submitContactCreation();
        returnToHomePage();
    }
    public int getContactCount() {
        return wd.findElements(By.name("entry")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//input[@name='selected[]']"));
        for (WebElement element : elements) {
            String email = element.getAttribute("accept");
            ContactData contact = new ContactData(null, null, null, "default", null, null, email, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
