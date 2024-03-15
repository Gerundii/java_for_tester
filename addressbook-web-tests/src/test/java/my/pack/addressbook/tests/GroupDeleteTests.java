package my.pack.addressbook.tests;

import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("Big")
                    .withHeader("Bang")
                    .withFooter("Boom"));
        }
    }

    @Test (enabled = true)
    public void testGroupDelete() throws Exception {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();

        assertThat(after, equalTo(before.without(deletedGroup)));

        verifyGroupListInUI();
    }

}
