package lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;
    private String groupName;
    private List<User> groupMembers = new ArrayList<>();

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    //Method
    public void addMember(User user) {
        if (!groupMembers.contains(user)) {
            groupMembers.add(user);
        }
    }

}
