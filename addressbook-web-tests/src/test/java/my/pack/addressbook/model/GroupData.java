package my.pack.addressbook.model;

import java.util.Objects;

public class GroupData {
    private int id;
    private String groupName;
    private String groupHeader;
    private String groupFooter;

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.id = Integer.MAX_VALUE;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public GroupData(int id, String groupName, String groupHeader, String groupFooter) {
        this.id = id;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }
    public GroupData setId(int id) {
        this.id = id;
        return this;
    }

    public GroupData setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }
    public GroupData setGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }
    public GroupData setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

}
