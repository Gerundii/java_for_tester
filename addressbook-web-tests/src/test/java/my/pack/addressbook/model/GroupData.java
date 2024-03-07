package my.pack.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;

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
    public GroupData withName(String groupName) {
        this.name = groupName;
        return this;
    }
    public GroupData withHeader(String groupHeader) {
        this.header = groupHeader;
        return this;
    }
    public GroupData withFooter(String groupFooter) {
        this.footer = groupFooter;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return getId() == groupData.getId() && Objects.equals(getName(), groupData.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", groupName='" + name + '\'' +
                '}';
    }

}
