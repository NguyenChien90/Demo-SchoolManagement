package ra.model;

public class Mark {
    private static int newId =1;
    private int markId;
    private Student student;
    private Subject subject;
    private double poin;

    public Mark() {
        this.markId = newId++;
    }

    public Mark(int markId, Student student, Subject subject, double poin) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.poin = poin;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoin() {
        return poin;
    }

    public void setPoin(double poin) {
        this.poin = poin;
    }

    @Override
    public String toString() {
        return "Mã điểm: " + markId +
                " - Tên sinh viên: " + student.getStudentName() +
                " - Tên môn học: " + subject.getSubjectName() +
                " - Điểm số: " + poin;
    }
}
