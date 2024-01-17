package my.pack.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoContactCreatePage() {
        if (! (isElementPresent(By.xpath("//h1[text()='Edit / add address book entry']")) && isElementPresent(By.name("submit")))) {
            click(By.linkText("add new"));
        }
    }
    public void gotoGroupPage() {
        if (! (isElementPresent(By.xpath("//h1[text()='Groups']")) && isElementPresent(By.name("new")))) {
            click(By.linkText("groups"));
        }
    }
    public void gotoHomePage() {
        if (! (isElementPresent(By.id("maintable")))) {
            click(By.linkText("home"));
        }

    }
}
