package my.pack.addressbook.model;

public class GroupData {
    public static GroupData testGroup = new GroupData("testGroup", "testHeader", "testFooter");
    public static GroupData modGroup = new GroupData("modGroup", "modHeader", "modFooter");
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
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
}
