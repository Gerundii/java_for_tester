package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupDeleteTests extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isAnyGroupExist()) {
      app.getGroupHelper().createGroup(GroupData.testGroup);
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
