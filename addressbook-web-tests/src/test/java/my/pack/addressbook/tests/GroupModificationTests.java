package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @Test
    public void testGroupModification () {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isAnyGroupExist()) {
            app.getGroupHelper().createGroup(new GroupData("testgroup", null, "firstTestFooter"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("mod2", "mod3", "mod4"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
