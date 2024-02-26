package my.pack.addressbook.model;

import org.openqa.selenium.InvalidArgumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ContactData {

    public static ContactData nibbler = new ContactData("Nibbler", "", "Ge", "Nibbler", "Lord", "", "nibbler@futurama.com", "", "1", "August", "2000", null);
    public static ContactData fry = new ContactData("Phillip", "J", "Fry", "Fry", "Delivery Guy", "+982-265-265-22", "fry@futurama.com", "", "31", "December", "1999", null);
    public static ContactData unknown = new ContactData("Unknown", "", "KumMan", "Unknown", "Somebody", "", "unknown@man.su", "", "13", "December", "1000", null);
    public static ContactData known = new ContactData("Known", "", "Man", "Unknown", "Somebody", "", "unknown@man.su", "", "13", "December", "1000", null);
    public static ArrayList<ContactData> contacts = new ArrayList<>(Arrays.asList(nibbler, fry, unknown, known));

    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String photoPath;
    private final String defaultPhotoPath;
    private final String title;
    private final String mobileTelephone;
    private final String email;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String group;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String mobileTelephone, String email, String homepage, String bday, String bmonth, String byear, String group) {
        this.id = 0;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.photoPath = (new File("./src/test/resources/" + nickname.toLowerCase() + ".jpg").getAbsolutePath());
        this.defaultPhotoPath = (new File("./src/test/resources/default.jpg").getAbsolutePath());
        this.title = title;
        this.mobileTelephone = mobileTelephone;
        this.email = email;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.group = group;
    }

    public ContactData(int id, String email) {
        this.id = id;
        this.firstname = null;
        this.middlename = null;
        this.lastname = null;
        this.nickname = "default";
        this.photoPath = (new File("./src/test/resources/" + nickname.toLowerCase() + ".jpg").getAbsolutePath());
        this.defaultPhotoPath = (new File("./src/test/resources/default.jpg").getAbsolutePath());
        this.title = null;
        this.mobileTelephone = null;
        this.email = email;
        this.homepage = null;
        this.bday = null;
        this.bmonth = null;
        this.byear = null;
        this.group = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getDefaultPhotoPath() {
        return defaultPhotoPath;
    }

    public String getTitle() {
        return title;
    }

    public String getMobileTelephone() {
        return mobileTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
