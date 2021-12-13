package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int studentCount;

    private int groupId;

    private int lowAge;

    private int highAge;

    private int studentCapacity;

    private List<Student> students;

    private Teacher teacher;

    private ClassRoom classRoom;

    public Group(int lowAge, int highAge, int personCapacity, int groupId, Teacher teacher) {

        this.groupId = groupId;
        this.lowAge = lowAge;
        this.highAge = highAge;
        this.studentCapacity = personCapacity;
        this.teacher = teacher;
        studentCount = 0;
        students = new ArrayList<>();

    }


    public int getPersonCount() {
        return studentCount;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getGroupCapacity() {
        return studentCapacity;
    }

    public int getLowAge() {
        return lowAge;
    }

    public int getHighAge() {
        return highAge;
    }

    public int getPersonCapacity() {
        return studentCapacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public boolean isFull() {
        return studentCapacity == studentCount;
    }

    public void addStudent(Student student) {
        if (isFull()) {
            return;
        }
        students.add(student);
        student.setTeacher(teacher);
        studentCount++;
    }

    public String toString(){
        return "{Group: " + getGroupId() + ", Students: " + getPersonCount() +"/"+ getPersonCapacity() + ", ageRange: [" + getLowAge() + " , " + getHighAge() + "], with teacher: (" + getTeacher() + ").}";
    }









}
