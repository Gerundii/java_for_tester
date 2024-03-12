package my.pack.addressbook.appmanager;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ApplicationManager {

    private String browser;
    public WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    public JavascriptExecutor js;
    private Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.EDGE.browserName())) {
            wd = new EdgeDriver();
        }
        //System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        js = (JavascriptExecutor) wd;
        wd.get(properties.getProperty("web.baseUrl"));
        //wd.get("http://192.168.0.106/addressbook/");
        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
        //sessionHelper.login("admin", "secret");
    }

    public void stop() {
        sessionHelper.logout();
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }
    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
