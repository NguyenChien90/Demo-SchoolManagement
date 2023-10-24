package ra.model;

public class Classroom {
    private static int newId = 1;
    private int classroomId;
    private String classroomName;
    private boolean status;

    public Classroom() {
        this.classroomId = newId++;
    }

    public Classroom(int classroomId, String classroomName, boolean status) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.status = status;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mã lớp học: " + classroomId + " - Tên lớp: " + classroomName +
                " - Trạng thái lớp: " + (status ? "Đang học":"Kết thúc");
    }
}
