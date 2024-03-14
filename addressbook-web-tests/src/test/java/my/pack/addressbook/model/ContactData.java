package my.pack.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;
import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;;
    @Expose
    @Column (name = "firstname")
    private String firstname;
    @Expose
    @Column (name = "lastname")
    private String lastname;
    @Expose
    @Column (name = "email")
    private String email;
    @Column (name = "email2")
    private String email2;
    @Column (name = "email3")
    private String email3;
    @Transient
    private String allEmails;
    @Column (name = "home")
    private String homePhone;
    @Column (name = "mobile")
    private String mobilePhone;
    @Column (name = "work")
    private String workPhone;
    @Transient
    private String allPhones;
    @Transient
    private String group;
    @Expose
    @Column (name = "photo")
    private String photo;

    @Column (name = "deprecated")
    private Timestamp deprecated;


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public ContactData withDeprecated(Timestamp deprecated) {
        this.deprecated = deprecated;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getGroup() {
        return group;
    }

    public String getPhoto() {
        return photo;
    }

    public Timestamp getDeprecated() {
        return deprecated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", deprecated=" + deprecated +
                '}';
    }

}
