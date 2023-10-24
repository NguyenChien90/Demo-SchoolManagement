package ra.model;

public class Mark extends Entity<Integer> {
    private static int newId =1;
    private Student student;
    private Subject subject;
    private double poin;

    public Mark() {
        this.id = newId++;
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
        return "Mã điểm: " + id +
                " - Tên sinh viên: " + student.getStudentName() +
                " - Tên môn học: " + subject.getSubjectName() +
                " - Điểm số: " + poin;
    }
}
