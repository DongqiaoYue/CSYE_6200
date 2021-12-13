package neu.edu.csye6200;

import java.util.*;

public class DayCare {

    private static DayCare dayCare;

    private static List<Student> students;

    private static List<Teacher> teachers;

    private static List<VaccRecord> vaccRecords;

    private static RatioRules ratioRules;

    private static int teacherIndex;

    private static int groupId;

    private static int classRoomId;

    private static boolean isFilled;

    private static HashMap<int[], List<ClassRoom>> school;

    private static User currentUser;

    private static int currentStudent;

    private static int currentTeacher;

    private static int currentClassRoom = 0;

    private static String currentDate = "1-2021"; // MM-yyyy

    private DayCare(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        school = new HashMap<>();
        vaccRecords = new ArrayList<>();
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
        dayCare.loadVaccRecord();
        dayCare.enrollAllStudents();
        dayCare.removeRedundantClassRoom();

        return dayCare;
    }

    public static DayCare getDayCare(){
        return dayCare;
    }

    public static int getCurrentClassRoom() {
        return currentClassRoom;
    }

    public static void setCurrentClassRoom(int currentClassRoom) {
        DayCare.currentClassRoom = currentClassRoom;
    }


    public static int getCurrentStudent() {
        return currentStudent;
    }

    public static void setCurrentStudent(int currentStudent) {
        DayCare.currentStudent = currentStudent;
    }

    public static int getCurrentTeacher() {
        return currentTeacher;
    }

    public static void setCurrentTeacher(int currentTeacher) {
        DayCare.currentTeacher = currentTeacher;
    }

    public static String getCurrentDate() {
        return currentDate;
    }

    public static void setCurrentDate(String currentDate) {
        changeAgeByCurrentDate(currentDate);
        DayCare.currentDate = currentDate;
    }


    public static void changeAgeByCurrentDate(String currentDate){
        for (int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            int oldAge = student.getAge();
            int mondiff = DateUtiles.getMonthDiff(currentDate, student.getUpdateDate());
            int newAge = mondiff + oldAge;
            student.setUpdateDate(currentDate);
            student.setAge(newAge);
        }
    }

    public void loadVaccRecord(){
        String fileName = "vacc.txt";
        List<String> vaccRecordCsv = FileUtils.read(fileName);
        for (String str : vaccRecordCsv){
            vaccRecords.add(VaccRecord.parseVaccRecord(str));
        }
    }

    public void loadStudents(){
        String fileName = "students.txt";
        List<String> studentsCsv = FileUtils.read(fileName);
        for (String str : studentsCsv){
            students.add(Student.parseStudent(str,currentDate));
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
        school = new HashMap<>();
        teacherIndex = 0;
        groupId = 0;
        classRoomId = 0;
        for (Student student : students){
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
        Teacher teacher = teachers.get(teacherIndex++);
        Group group = new Group(studentAgeRange[0], studentAgeRange[1], ratioRules.getSCByRange(studentAgeRange), groupId++, teacher);
        teacher.setGroup(group);
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



    public void createUser(){
        currentUser = User.getInstance();
    }

    public boolean isLoggedIn(){
        return currentUser.isUserLoggedIn();
    }

    public void setUserType(String type){
        currentUser.setUserTypeEnum(type);
    }

    public UserTypeEnum getUserType(){
        return currentUser.getUserTypeEnum();
    }

    public boolean LogIn(String username, String password){
        boolean match = false;
        if (currentUser.getUserTypeEnum() == UserTypeEnum.TEACHER){
            for (Teacher teacher : teachers){
                if (teacher.getName().equals(username) && password.equals("0000")){
                    currentUser.setUsername(username);
                    setCurrentTeacher(teacher.getTeacherId());
                    if (teacher.getGroup() != null) {
                        setCurrentStudent(teacher.getGroup().getStudents().get(0).getStudentId());
                    }
                    match = true;
                }
            }
        }else if (currentUser.getUserTypeEnum() == UserTypeEnum.STUDENT){
            for (Student student : students){
                if (student.getName().equals(username) && password.equals("0000")){
                    currentUser.setUsername(username);
                    setCurrentStudent(student.getStudentId());
                    if (student.getTeacher() != null) {
                        setCurrentTeacher(student.getTeacher().getTeacherId());
                    }
                    match = true;
                }
            }
        }
        currentUser.login();
        return match;
    }

    public void logout(){
        currentUser.logout();
    }

    public List<String> findTeacherInfoById(int id){
        List<String> teacherInfo = new ArrayList<>();
        for (Teacher teacher : teachers){
            if (teacher.getTeacherId() == id){
                teacherInfo.add(String.valueOf(teacher.getTeacherId()));
                teacherInfo.add(teacher.getName());
                teacherInfo.add(String.valueOf(teacher.getAge()));
            }

        }
        if (teacherInfo.size() == 0){
            for (int i = 0; i < 3; i++){
                teacherInfo.add("Not Found In Database");
            }
        }
        return teacherInfo;
    }

    public String findGroupInfoById(int id){
        String groupInfo = "You have not be assigned yet";
        for (Teacher teacher : teachers){
            if (teacher.getTeacherId() == id){
                if (teacher.getGroup() != null){
                    groupInfo = teacher.getGroup().toString();
                }
            }
        }
        return groupInfo;
    }

    public List<String> findStudentInfoById(int id){
        List<String> studentInfo = new ArrayList<>();
        boolean isEnrolled = false;
        for (Student student : students){
            if (id == student.getStudentId()){
                if (student.getTeacher() != null) {
                    studentInfo.add(student.getTeacher().getName());
                }else {
                    studentInfo.add("Not enrolled yet");
                }
                studentInfo.add(student.getName());
                studentInfo.add(String.valueOf(student.getAge()));
                studentInfo.add(student.getParentName());
                studentInfo.add(student.getAddress());
                studentInfo.add(student.getPhone());
            }
        }
        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            for (ClassRoom classRoom : entry.getValue()){
                for (Group group : classRoom.getGroups()){
                    for (Student student : group.getStudents()){
                        if (student.getStudentId() == id){
                            isEnrolled = true;
                            studentInfo.add(classRoom.getRoomId() + "(" + group.getGroupId() + ")");

                        }
                    }
                }
            }
        }
        if (!isEnrolled){
            studentInfo.add("Not enrolled yet");
        }

        for (VaccRecord vaccRecord : vaccRecords){
            if (vaccRecord.getStudentId() == id){
                studentInfo.add(String.valueOf(vaccRecord.getHib()));
                studentInfo.add(String.valueOf(vaccRecord.getDTaP()));
                studentInfo.add(String.valueOf(vaccRecord.getPolio()));
                studentInfo.add(String.valueOf(vaccRecord.getHepatitsB()));
                studentInfo.add(String.valueOf(vaccRecord.getMMR()));
                studentInfo.add(String.valueOf(vaccRecord.getVaricella()));
            }
        }

        if (studentInfo.size() < 13){
            for (int i = 0; i < 13; i++){
                studentInfo.add("Not Found In Database");
            }
        }
        return studentInfo;
    }

    public Vector<Vector<String>> findAllClassRoomsInfo(){
        Vector<Vector<String>> allClassRoomsInfo = new Vector<>();
        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            for (ClassRoom classRoom : entry.getValue()){
                Vector<String> temp = new Vector<>();
                temp.add(String.valueOf(classRoom.getRoomId()));
                temp.add(String.valueOf(classRoom.getGroupCapacity()));
                temp.add(classRoom.isFull() ? "Full" : "Not Full");
                temp.add("["+classRoom.getLowAge() + "," + classRoom.getHighAge() + "]");
                allClassRoomsInfo.add(temp);
            }
        }
        allClassRoomsInfo.sort(new Comparator<Vector<String>>() {
            @Override
            public int compare(Vector<String> o1, Vector<String> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return allClassRoomsInfo;
    }

    public Vector<Vector<String>> findGroupsInfoByClassRoomID(int id){
        Vector<Vector<String>> allGroupsInfo = new Vector<>();
        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            for (ClassRoom classRoom : entry.getValue()){
                if (classRoom.getRoomId() == id){
                    for (Group group : classRoom.getGroups()){
                        Vector<String> temp = new Vector<>();
                        temp.add(String.valueOf(group.getGroupId()));
                        temp.add(group.getTeacher().getName());
                        temp.add(String.valueOf(group.getPersonCount()));
                        temp.add(String.valueOf(group.getPersonCapacity()));
                        allGroupsInfo.add(temp);
                    }
                }
            }
        }
        return allGroupsInfo;
    }

    public int findTeacherIdByGroupId(int id){
        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            for (ClassRoom classRoom : entry.getValue()){
                if (classRoom.getRoomId() == id){
                    for (Group group : classRoom.getGroups()){
                        if (group.getGroupId() == id){
                            return group.getTeacher().getTeacherId();
                        }
                    }
                }
            }
        }
        return 0;
    }

    public String findClassRoomInfoByID(int id){
        String res = "Not Found In Database";
        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            for (ClassRoom classRoom : entry.getValue()){
                if (classRoom.getRoomId() == id){
                    res = classRoom.toString();
                }
            }
        }
        return res;
    }

    public String findSchoolInfo(){
        return "GROUP TWO DAYCARE SCHOOL :" + getStudentCount() + "students and " + getTeacherCount()+ "teachers, Status: " + (isFull()? "Full": "Not FULL");
    }

    public Vector<Vector<String>> findAllStudentsInfoByID(int id){
        Vector<Vector<String>> allStudentsInfo = new Vector<>();
        for (Teacher teacher : teachers){
            if (teacher.getTeacherId() == id){
                if (teacher.getGroup() != null && teacher.getGroup().getStudents() != null){
                    for (Student student : teacher.getGroup().getStudents()){
                        Vector<String> temp = new Vector<>();
                        temp.add(String.valueOf(student.getStudentId()));
                        temp.add(student.getName());
                        temp.add(String.valueOf(student.getAge()));
                        allStudentsInfo.add(temp);
                    }
                }else {
                    System.out.println("Teacher not exist");
                }
            }
        }
        return allStudentsInfo;
    }

    public List<String> findVaccRecordInfoByID(int id){
        List<String> vaccRecordInfo = new ArrayList<>();
        for (VaccRecord vaccRecord : vaccRecords){
            if (vaccRecord.getStudentId() == id){
                vaccRecordInfo.add(String.valueOf(vaccRecord.getHib()));
                vaccRecordInfo.add(String.valueOf(vaccRecord.getDTaP()));
                vaccRecordInfo.add(String.valueOf(vaccRecord.getPolio()));
                vaccRecordInfo.add(String.valueOf(vaccRecord.getHepatitsB()));
                vaccRecordInfo.add(String.valueOf(vaccRecord.getMMR()));
                vaccRecordInfo.add(String.valueOf(vaccRecord.getVaricella()));
                return vaccRecordInfo;
            }
        }
        for (int i = 0; i < 6; i++){
            vaccRecordInfo.add("Not Found In Database");
        }
        return vaccRecordInfo;
    }

    public List<Integer> findRequiredDoseByID(int id){
        int age = -1;
        for (Student student : students){
            if (student.getStudentId() == id){
                age = student.getAge();
            }
        }

        List<Integer> requiredDose = new ArrayList<>();
        if (age == -1){
            for (int i = 0; i < 6; i++){
                requiredDose.add(-1);
                return requiredDose;
            }
        }
        if (age < 24) {
            for (int i = 0; i < 6; i++) {
                requiredDose.add(-1);
            }
            return requiredDose;
        }else if (age >= 24 && age < 60){
            requiredDose.add(1);
            requiredDose.add(4);
            requiredDose.add(3);
            requiredDose.add(3);
            requiredDose.add(1);
            requiredDose.add(1);
        }else if (age > 60){
            requiredDose.add(5);
            requiredDose.add(4);
            requiredDose.add(4);
            requiredDose.add(3);
            requiredDose.add(2);
            requiredDose.add(2);
        }
        return  requiredDose;
    }


    public List<String> findVaccUpdateDateInfoByID(int id){
        List<String> vaccUpdateDate = new ArrayList<>();
        for (VaccRecord vaccRecord : vaccRecords){
            if (vaccRecord.getStudentId() == id){
                vaccUpdateDate.add(String.valueOf(vaccRecord.getHibLastUpdateDate()));
                vaccUpdateDate.add(String.valueOf(vaccRecord.getDTapLastUpdateDate()));
                vaccUpdateDate.add(String.valueOf(vaccRecord.getPoliLastUpdateDate()));
                vaccUpdateDate.add(String.valueOf(vaccRecord.getHepatitsBLastUpdateDate()));
                vaccUpdateDate.add(String.valueOf(vaccRecord.getMMRLastUpdateDate()));
                vaccUpdateDate.add(String.valueOf(vaccRecord.getVaricellaLastUpdateDate()));
                return vaccUpdateDate;
            }
        }
        for (int i = 0; i < 6; i++){
            vaccUpdateDate.add("Not Found In Database");
        }
        return vaccUpdateDate;
    }


    // compliance(green) overdue(red) not compliance(yellow)
    public List<String> findVaccStatusByID(int id){
        List<String> vaccStatus = new ArrayList<>();
        List<String> vaccUpdateDate = findVaccUpdateDateInfoByID(id);
        List<Integer> requiredDose = findRequiredDoseByID(id);
        boolean isOverDue = true;
        if (vaccUpdateDate.size() == 0 || vaccUpdateDate.get(0).equals("Not Found In Database")){
            isOverDue = false;
        }
        int age = -1;
        for (Student student : students){
            if (student.getStudentId() == id){
                age = student.getAge();
            }
        }
        if (age == -1){
            for (int i = 0; i < 6; i++){
                vaccStatus.add("Not Found In Database");
                return  vaccStatus;
            }
        }
        for (VaccRecord vaccRecord : vaccRecords){
            if (vaccRecord.getStudentId() == id){
                if (requiredDose.get(0) <= vaccRecord.getHib()){
                    vaccStatus.add("Compliance");
                }else if (requiredDose.get(0) > vaccRecord.getHib() && DateUtiles.getMonthDiff(currentDate,vaccUpdateDate.get(0)) > 12 && isOverDue){
                    vaccStatus.add("Overdue");
                }else {
                    vaccStatus.add("Not compliance");
                }

                if (requiredDose.get(1) <= vaccRecord.getDTaP()){
                    vaccStatus.add("Compliance");
                }else if (requiredDose.get(1) > vaccRecord.getDTaP() && DateUtiles.getMonthDiff(currentDate,vaccUpdateDate.get(1)) > 12 && isOverDue){
                    vaccStatus.add("Overdue");
                }else {
                    vaccStatus.add("Not compliance");
                }

                if (requiredDose.get(2) <= vaccRecord.getPolio()){
                    vaccStatus.add("Compliance");
                }else if (requiredDose.get(2) > vaccRecord.getPolio() && DateUtiles.getMonthDiff(currentDate,vaccUpdateDate.get(2)) > 12 && isOverDue){
                    vaccStatus.add("Overdue");
                }else {
                    vaccStatus.add("Not compliance");
                }

                if (requiredDose.get(3) <= vaccRecord.getHepatitsB()){
                    vaccStatus.add("Compliance");
                }else if (requiredDose.get(3) > vaccRecord.getHepatitsB() && DateUtiles.getMonthDiff(currentDate,vaccUpdateDate.get(3)) > 12 && isOverDue){
                    vaccStatus.add("Overdue");
                }else {
                    vaccStatus.add("Not compliance");
                }

                if (requiredDose.get(4) <= vaccRecord.getMMR()){
                    vaccStatus.add("Compliance");
                }else if (requiredDose.get(4) > vaccRecord.getMMR() && DateUtiles.getMonthDiff(currentDate,vaccUpdateDate.get(4)) > 12 && isOverDue){
                    vaccStatus.add("Overdue");
                }else {
                    vaccStatus.add("Not compliance");
                }

                if (requiredDose.get(5) <= vaccRecord.getVaricella()){
                    vaccStatus.add("Compliance");
                }else if (requiredDose.get(5) > vaccRecord.getVaricella() && DateUtiles.getMonthDiff(currentDate,vaccUpdateDate.get(5)) > 12 && isOverDue){
                    vaccStatus.add("Overdue");
                }else {
                    vaccStatus.add("Not compliance");
                }


            }
        }

        return  vaccStatus;

    }

    public int findStudentAgeByID(int id){
        int age = -1;
        for (Student student : students){
            if (student.getStudentId() == id){
                age = student.getAge();
            }
        }
        return age;

    }

    public static int getStudentCount(){
        return students.size();
    }

    public static int getTeacherCount() {return  teachers.size();}

    public void addStudent(Student student){
        students.add(student);
        System.out.println(student + "add successfully");
        insertAllStudents("students.txt");
    }

    public void insertAllStudents(String fileName){
        List<String> studentCsvs = new ArrayList<>();
        for (Student student : students){
            studentCsvs.add(student.toString());
        }
        FileUtils.write(fileName, studentCsvs);
    }

    public void insertVaccRecord(String vaccRecordCsv){
        VaccRecord vaccRecord = VaccRecord.parseVaccRecord(vaccRecordCsv);
        vaccRecords.add(vaccRecord);
        System.out.println(vaccRecordCsv + "add successfully");
        List<String> vaccRecordCsvs = new ArrayList<>();
        for (VaccRecord vaccRecord1 : vaccRecords){
            vaccRecordCsvs.add(vaccRecord1.toString());
        }
        String fileName = "vacc.txt";
        FileUtils.write(fileName, vaccRecordCsvs);
    }

    public void insertTeacher(String teacherCsv){
        Teacher teacher = Teacher.parseTeacher(teacherCsv);
        teachers.add(teacher);
        System.out.println(teacher + "add successfully");
        List<String> teacherCsvs = new ArrayList<>();
        for (Teacher teacher1 : teachers){
            teacherCsvs.add(teacher1.toString());
        }
        String fileName = "teachers.txt";
        FileUtils.write(fileName, teacherCsvs);
    }

    public List<String> getSchool(){
        List<String> s = new ArrayList<>();
        for (Person p : dayCare.students){
            s.add(p.toString());
        }

        for (Person p : dayCare.teachers){
            s.add(p.toString());
        }

        for (Map.Entry<int[], List<ClassRoom>> entry : school.entrySet()){
            s.add("[" + entry.getKey()[0] + ", " + entry.getKey()[1] + "]");
            for (ClassRoom classRoom : entry.getValue()){
                s.add(classRoom.toString());
                for (Group group: classRoom.getGroups()){
                    s.add(group.toString());
                    for (Person student: group.getStudents()){
                        s.add(student.toString());
                    }
                }
            }
        }
        return s;
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
        dayCare.loadVaccRecord();
        for (VaccRecord vaccRecord : vaccRecords){
            System.out.println(vaccRecord);
        }

        for (Teacher teacher : teachers){
            if (teacher.getGroup() == null){
                System.out.println("error");
            }
        }

    }
}
