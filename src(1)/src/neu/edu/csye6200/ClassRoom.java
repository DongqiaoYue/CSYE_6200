package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

    private int roomId;

    private int groupCount;

    private int groupCapacity;

    private List<Group> groups;

    private int lowAge;

    private int highAge;

    public void addGroup(Group group) {
        if (groupCapacity == groupCount) return;
        groups.add(group);
        groupCount += 1;
    }

    public ClassRoom(int id, int groupCapacity, int lowAge, int highAge) {
        this.groupCapacity = groupCapacity;
        groups = new ArrayList<>();
        groupCount = 0;
        roomId = id;
        this.lowAge = lowAge;
        this.highAge = highAge;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getLowAge() {
        return lowAge;
    }

    public int getHighAge() {
        return highAge;
    }

    public int getGroupCapacity() {
        return groupCapacity;
    }

    public boolean isFull() {
        if (groupCapacity == groupCount){
            for (Group group: getGroups()){
                if (!group.isFull()){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public String toString(){
        return "{ ClassRoom "+ getRoomId() + ", with " + getGroupCount() + "/" + getGroupCapacity() + " Groups, Grade : ["+getLowAge() + "," + getHighAge() + "].}";
    }

}