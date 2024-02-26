package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase{
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();

    GroupData group = new GroupData("Vivi", "Kolo", "Gaga");

    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    Comparator<GroupData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

    int max = after.stream().max(byId).get().getId();
    group.setId(max);

    before.add(group);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
