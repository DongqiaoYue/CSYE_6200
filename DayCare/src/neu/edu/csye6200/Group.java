package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int studentCount;

    private int groupId;

    private int lowAge;

    private int highAge;

    private int studentCapacity;

    private List<Person> students;

    private Person teacher;

    private ClassRoom classRoom;

    public Group(int lowAge, int highAge, int personCapacity, int groupId, Person teacher) {

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

    public List<Person> getStudents() {
        return students;
    }

    public Person getTeacher() {
        return teacher;
    }

    public boolean isFull() {
        return studentCapacity == studentCount;
    }

    public void addStudent(Person student) {
        if (isFull()) {
            return;
        }
        students.add(student);
        studentCount++;
    }

    public String toString(){
        return "{Group: " + getGroupId() + ", Students: " + getPersonCount() +"/"+ getPersonCapacity() + ", ageRange: [" + getLowAge() + " , " + getHighAge() + "], with teacher: (" + getTeacher() + ").}";
    }









}
