package ra.model;

public class Subject extends Entity<Integer> {
    private static int newId = 1;
    private String subjectName;

    public Subject() {
        this.id =newId++;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return  "Mã môn học: " + id +
                " - Tên môn học: " + subjectName;
    }
}
