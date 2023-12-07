package my.pack.addressbook;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String mobileTelephone;
    private final String email;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String new_group;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String mobileTelephone, String email, String homepage, String bday, String bmonth, String byear, String new_group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.mobileTelephone = mobileTelephone;
        this.email = email;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.new_group = new_group;
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

    public String getNew_group() {
        return new_group;
    }
}
