package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withGroupName("Big").withGroupHeader("Bang").withGroupFooter("Boom"));
        }
    }

    @Test (enabled = true)
    public void testGroupDelete() throws Exception {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().all();

        assertThat(after, equalTo(before.without(deletedGroup)));
    }

}
