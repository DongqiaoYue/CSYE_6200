package neu.edu.csye6200;

public class Teacher extends Person {

    private int credits;

    private int teacherId;

    private Group group;

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isAssigned(){
        return group == null || group.getStudents() == null || group.getStudents().size() == 0;
    }

    public static Teacher parseTeacher(String teacherCSV){
        String[] strs = teacherCSV.split(",");
        Teacher teacher = new Teacher();
        teacher.setTeacherId(Integer.valueOf(strs[0]));
        teacher.setName(strs[1]);
        teacher.setAge(Integer.valueOf(strs[2]));
        teacher.setCredits(Integer.valueOf(strs[3]));
        return teacher;
    }

    public String toString(){
        return getTeacherId() + ","
                + getName() + ","
                + getAge() + ","
                + getCredits();
    }



}

