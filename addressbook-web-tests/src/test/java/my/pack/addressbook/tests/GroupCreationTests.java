package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
    @Test(enabled = true)
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withGroupName("Vivi").withGroupHeader("Kolo").withGroupFooter("Gaga");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();

        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt(o -> o.getId()).max().getAsInt()))));
    }
    @Test(enabled = true)
    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withGroupName("Bad'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
