package ra.model;

public class Subject {
    private static int newId = 1;
    private int subjectId;
    private String subjectName;

    public Subject() {
        this.subjectId =newId++;
    }

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return  "Mã môn học: " + subjectId +
                " - Tên môn học: " + subjectName;
    }
}
