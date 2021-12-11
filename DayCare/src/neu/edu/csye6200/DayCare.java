package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayCare {

    private static DayCare dayCare;

    private static List<Person> students;

    private static List<Person> teachers;

    private static RatioRules ratioRules;

    private static int teacherIndex;

    private static int groupId;

    private static int classRoomId;

    private static boolean isFilled;

    private static HashMap<int[], List<ClassRoom>> school;

    private DayCare(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        school = new HashMap<>();
        teacherIndex = 0;
        groupId = 0;
        classRoomId = 0;
        isFilled = false;
    }


    public static DayCare getInstance(){
        dayCare = new DayCare();
        //all initialization methods should be called here
        dayCare.loadStudents();
        dayCare.loadRatioRules();
        dayCare.loadTeacher();
        dayCare.enrollAllStudents();
        dayCare.removeRedundantClassRoom();

        return dayCare;
    }

    public void loadStudents(){
        String fileName = "students.txt";
        List<String> studentsCsv = FileUtils.read(fileName);
        for (String str : studentsCsv){
            students.add(Student.parseStudent(str));
        }
    }

    public void loadTeacher(){
        String fileName = "teachers.txt";
        List<String> teachersCsv = FileUtils.read(fileName);
        for (String str : teachersCsv){
            teachers.add(Teacher.parseTeacher(str));
        }

    }

    public void loadRatioRules(){
        String fileName = "ratioRules.txt";
        List<String> ratioRulesCsv = FileUtils.read(fileName);
        ratioRules = new RatioRules();
        ratioRules.parseAndLoadRatioRules(ratioRulesCsv);
    }

    /**
     * try to enroll all student, if all students can not be enrolled(due to limitation of teacher) will stop enrollment, and change the status isFilled to true;
     */

    public void enrollAllStudents(){
        for (Person student : students){
            ClassRoom tempClassRoom = searchClassRoomFromSchool(student, school, ratioRules);
            Group tempGroup = searchGroupFromClassRoom(student, tempClassRoom, ratioRules);
            if (tempGroup == null){
                isFilled = true;
                continue;
            }
            tempGroup.addStudent(student);
        }
    }

    /**
     * search ClassRoom from school(in same grade), if all current classRooms are full, then create one
     * @param student
     * @param school
     * @param ratioRules
     * @return ClassRoom
     */

    public ClassRoom searchClassRoomFromSchool(Person student, HashMap<int[], List<ClassRoom>> school, RatioRules ratioRules){

        // check whether all current classRooms are full

        int[] studentAgeRange = ratioRules.findRangeByAge(student.getAge());
        if (!school.containsKey(studentAgeRange)){
            school.put(studentAgeRange, new ArrayList<>());
        }
        List<ClassRoom> classRooms = school.get(studentAgeRange);
        for (ClassRoom classRoom : classRooms){
            if (!classRoom.isFull()){
                return classRoom;
            }
        }

        // if all current classRooms are full, create new classRoom

        ClassRoom classRoom = new ClassRoom(classRoomId++, ratioRules.getGCByRange(studentAgeRange), studentAgeRange[0], studentAgeRange[1]);
        classRooms.add(classRoom);
        return classRoom;
    }

    /**
     * search group from ClassRoom, if all current groups are full, then create one and assign a teacher
     * @param student
     * @param classRoom
     * @param ratioRules
     * @return Group
     */

    public Group searchGroupFromClassRoom(Person student, ClassRoom classRoom, RatioRules ratioRules){

        //checker whether all current classRooms are Full

        int[] studentAgeRange = ratioRules.findRangeByAge(student.getAge());
        for (Group group: classRoom.getGroups()){
            if (!group.isFull()){
                return group;
            }
        }
        // if all teachers are assigned then return null as signal;
        if (teacherIndex >= teachers.size()) return null;
        //assign a new teacher to the new group
        Group group = new Group(studentAgeRange[0], studentAgeRange[1], ratioRules.getSCByRange(studentAgeRange), groupId++, teachers.get(teacherIndex++));
        classRoom.addGroup(group);
        return group;
    }

    public boolean isFull(){
        return isFilled;
    }

    /**
     * Since I do not check the possible teacher in function searchClassRoomFromSchool so this function is needed, may be removed in later version
     */

    public void removeRedundantClassRoom(){
        for (int[] key : school.keySet()){
            List<ClassRoom> temp = school.get(key);
            for (int i = 0; i < temp.size(); i++){
                if (temp.get(i).getGroupCount() == 0){
                    temp.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        //test
        DayCare dayCare = DayCare.getInstance();
        dayCare.loadRatioRules();
        System.out.println(dayCare.ratioRules.findRangeByAge(11)[0] + ":" + dayCare.ratioRules.findRangeByAge(11)[1]);
        System.out.println(dayCare.ratioRules.findRangeByAge(21)[0] + ":" + dayCare.ratioRules.findRangeByAge(21)[1]);
        System.out.println(dayCare.ratioRules.findRangeByAge(31)[0] + ":" + dayCare.ratioRules.findRangeByAge(31)[1]);
        System.out.println(dayCare.ratioRules.findRangeByAge(41)[0] + ":" + dayCare.ratioRules.findRangeByAge(41)[1]);
        System.out.println(dayCare.ratioRules.findRangeByAge(51)[0] + ":" + dayCare.ratioRules.findRangeByAge(51)[1]);
        System.out.println(dayCare.ratioRules.findRangeByAge(61)[0] + ":" + dayCare.ratioRules.findRangeByAge(61)[1]);
        System.out.println(dayCare.ratioRules.getSCByRange(new int[]{6,12}));
        System.out.println(dayCare.ratioRules.getGCByRange(new int[]{6,12}));
        System.out.println(dayCare.ratioRules.getSCByRange(new int[]{13,24}));
        System.out.println(dayCare.ratioRules.getGCByRange(new int[]{13,24}));
        System.out.println(dayCare.ratioRules.getSCByRange(new int[]{25,35}));
        System.out.println(dayCare.ratioRules.getGCByRange(new int[]{25,35}));
        System.out.println(dayCare.ratioRules.getSCByRange(new int[]{36,47}));
        System.out.println(dayCare.ratioRules.getGCByRange(new int[]{36,47}));
        System.out.println(dayCare.ratioRules.getSCByRange(new int[]{48,59}));
        System.out.println(dayCare.ratioRules.getGCByRange(new int[]{48,59}));

        for (Person p : dayCare.students){
            System.out.println(p);
        }

        for (Person p : dayCare.teachers){
            System.out.println(p);
        }

        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            System.out.println("[" + entry.getKey()[0] + ", " + entry.getKey()[1] + "]");
            for (ClassRoom classRoom : entry.getValue()){
                System.out.println(classRoom);
                for (Group group: classRoom.getGroups()){
                    System.out.println(group);
                    for (Person student: group.getStudents()){
                        System.out.println(student);
                    }
                }
            }
        }

        System.out.println(dayCare.isFull());
    }



}
