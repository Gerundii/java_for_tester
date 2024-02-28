package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withGroupName("Big").withGroupHeader("Bang").withGroupFooter("Boom"));
        }
    }

    @Test (enabled = true)
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withGroupName("modificator");
        app.group().modify(group);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
