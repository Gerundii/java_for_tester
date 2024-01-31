package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GroupCreationTests extends TestBase{
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(GroupData.testGroup);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
