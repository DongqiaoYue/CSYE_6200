package neu.edu.csye6200;

public class Student extends Person{

    private int studentId;

    private int grade;

    private String parentName;

    private String address;

    private String phone;

    private VaccRecord vaccRecord;

    private String updateDate;

    private Teacher teacher;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VaccRecord getVaccRecord() {
        return vaccRecord;
    }

    public void setVaccRecord(VaccRecord vaccRecord) {
        this.vaccRecord = vaccRecord;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student(int studentId, int age, String name, int grade, String parentName, String address, String phone, VaccRecord vaccRecord) {
        super(age,name);
        this.studentId = studentId;
        this.grade = grade;
        this.parentName = parentName;
        this.address = address;
        this.phone = phone;
        this.vaccRecord = vaccRecord;
    }

    public Student(){

    }

    public static Student parseStudent(String Csv, String currentDate){
        String[] strs = Csv.split(",");
        Student temp = new Student();
        temp.setStudentId(Integer.parseInt(strs[0]));
        temp.setName(strs[1]);
        temp.setAge(Integer.valueOf(strs[2]));
        temp.setGrade(Integer.parseInt(strs[3]));
        temp.setPhone(strs[4]);
        temp.setParentName(strs[5]);
        temp.setAddress(strs[6]);
        temp.setUpdateDate(strs[7]);


        return temp;
    }

    public String toString(){
        return getStudentId() + ","
                + getName() + ","
                + getAge() + ","
                + getGrade() + ","
                + getPhone() + ","
                + getParentName() + ","
                + getAddress() + ","
                + getUpdateDate();
    }

}
