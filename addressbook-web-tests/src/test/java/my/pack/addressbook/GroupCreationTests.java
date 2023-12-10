package my.pack.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("firstTest", "firstTestHeader", "firstTestFooter"));
    submitGroupCreation();
    returnToGroupPage();
    logout();
  }

}
