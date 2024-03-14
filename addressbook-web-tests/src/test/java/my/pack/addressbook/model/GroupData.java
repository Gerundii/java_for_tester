package my.pack.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
    @Id
    @Column(name = "group_id")
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Column (name = "group_name")
    @Expose
    private String name;
    @Column (name = "group_header")
    @Expose
    private String header;
    @Column (name = "group_footer")
    @Expose
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
