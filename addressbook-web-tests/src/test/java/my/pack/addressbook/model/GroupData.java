package my.pack.addressbook.model;

import java.util.Objects;

public class GroupData {
    private int id = Integer.MAX_VALUE;
    private String groupName;
    private String groupHeader;
    private String groupFooter;

    /*public GroupData(String groupName, String groupHeader, String groupFooter) {
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
    }*/
    public GroupData withId(int id) {
        this.id = id;
        return this;
    }
    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }
    public GroupData withGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }
    public GroupData withGroupFooter(String groupFooter) {
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
        return getId() == groupData.getId() && Objects.equals(getGroupName(), groupData.getGroupName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGroupName());
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

}
