package ra.model;

import java.io.Serializable;

public class Classroom extends Entity<Integer> {
    private static final long serialVersionUID = 1L;
    private String classroomName;
    private boolean status;

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
        return "Mã lớp học: " + id + " - Tên lớp: " + classroomName +
                " - Trạng thái lớp: " + (status ? "Đang học":"Kết thúc");
    }
}
