package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withGroupName("test1").withGroupHeader("header1").withGroupFooter("footer1")});
        list.add(new Object[] {new GroupData().withGroupName("test2").withGroupHeader("header2").withGroupFooter("footer2")});
        list.add(new Object[] {new GroupData().withGroupName("test3").withGroupHeader("header3").withGroupFooter("footer3")});
        return list.iterator();
    }

    @Test(enabled = true, dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
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
