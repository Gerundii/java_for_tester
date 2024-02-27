package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GroupDeleteTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (app.getGroupHelper().getGroupList().size() == 0) {
            app.getGroupHelper().createGroup(new GroupData("Big", "Bang", "Boom"));
        }
    }

    @Test (enabled = true)
    public void testGroupDelete() throws Exception {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        app.getGroupHelper().deleteGroup(index);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(after, before);
    }

}
