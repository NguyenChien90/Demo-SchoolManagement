package ra.service.student;

import ra.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    static List<Student> studentList = new ArrayList<>();
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(Student student) {
        Student studentEdit = findByID(student.getId());
        studentEdit.setStudentName(student.getStudentName());
        studentEdit.setClassroom(student.getClassroom());
        studentEdit.setAddress(student.getAddress());
        studentEdit.setPhone(student.getPhone());

    }

    @Override
    public void delete(int id) {
        Student studentDelete = findByID(id);
        studentList.remove(studentDelete);

    }

    @Override
    public Student findByID(int id) {
        for (Student student : studentList) {
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public int getNewId() {
        return 0;
    }
}
