package Group;

public class Groups {

    enum GroupRating { GENERAL, VIP, VVIP}
    private Group[] groups;
    private GroupRating groupRating;

    Groups() {}

    Groups(Group[] groups) {
        this.groups = groups;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public GroupRating getGroupRating() {
        return groupRating;
    }

    public void setGroupRating(GroupRating groupRating) {
        this.groupRating = groupRating;
    }

    public Groups[] gropGrading(Group[] groups) {
        Groups[] result = new Groups[3];
        result[0].setGroupRating(GroupRating.GENERAL);
        result[1].setGroupRating(GroupRating.VIP);
        result[2].setGroupRating(GroupRating.VVIP);

        /*판별 기준 가져와서 판별하는 내용*/

        return result;
    }


}
