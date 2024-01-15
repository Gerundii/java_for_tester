package my.pack.addressbook.appmanager;

import my.pack.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    private final String defaultPhotoPath = (new File("./src/test/resources/default.jpg").getAbsolutePath());;

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        try {
            addImg(By.xpath("//input[@type='file']"), contactData.getPhotoPath());
        } catch (InvalidArgumentException e) {
            addImg(By.xpath("//input[@type='file']"), defaultPhotoPath);
        }
        type(By.name("title"), contactData.getTitle());
        type(By.name("mobile"), contactData.getMobileTelephone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
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
}
