package ra.model;

public class Student {
    private  static int newId = 1;
    private int studentId;
    private String studentName;
    private Classroom classroom;
    private String birthday;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
        this.studentId = newId++;
    }

    public Student(int studentId, String studentName, Classroom classroom, String birthday, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classroom = classroom;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Mã sinh viên: " + studentId +
                " - Tên sinh viên: " + studentName +
                " - Tên lớp: " + classroom.getClassroomName() +
                " - Ngày sinh: " + birthday +
                " - Địa chỉ: " + address +
                " - Giới tính: " + gender +
                " - Điện thoại: " + phone;
    }
}
