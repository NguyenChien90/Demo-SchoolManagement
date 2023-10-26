package ra.service.student;

import ra.constant.FileName;
import ra.model.Student;
import ra.repo.FileRepository;

import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    private FileRepository<Student, Integer> studentRepository;

    public StudentServiceIMPL() {
        this.studentRepository = new FileRepository<>(FileName.STUDENT);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student findByID(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public int getNewId() {
        return studentRepository.getNewId();
    }

    public Student findByUserId(Integer userId) {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getUserId() == userId) {
                return student;
            }
        }

        return null;
    }
}
