package my.pack.addressbook.model;

import java.util.Objects;

public class GroupData {
    public static GroupData testGroup = new GroupData("testGroup", "testHeader", "testFooter");
    public static GroupData modGroup = new GroupData("modGroup", "modHeader", "modFooter");
    public static GroupData nullGroup = new GroupData("nullGroup", null, null);

    private int id;
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.id = 0;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public GroupData(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
        this.groupHeader = null;
        this.groupFooter = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id && Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }
}
