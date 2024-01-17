package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import org.testng.annotations.*;

public class GroupDeleteTests extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isAnyGroupExist()) {
      app.getGroupHelper().createGroup(new GroupData("testgroup", null, "firstTestFooter"));

    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
