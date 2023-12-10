package my.pack.addressbook.tests;

import my.pack.addressbook.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("firstTest", "firstTestHeader", "firstTestFooter"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    app.logout();
  }

}
