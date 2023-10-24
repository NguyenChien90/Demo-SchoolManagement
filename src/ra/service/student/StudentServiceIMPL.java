package ra.service.student;

import ra.model.Student;
import ra.service.classroom.ClassroomServiceIMPL;
import ra.service.classroom.IClassroomService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    static IClassroomService classroomService = new ClassroomServiceIMPL();
    static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Chien",classroomService.findAll().get(0),"1/1/1999","HN",true,"0988812345"));
        studentList.add(new Student(2,"Trang",classroomService.findAll().get(2),"2/2/2000","HN",false,"0984565645"));
        studentList.add(new Student(3,"Hung",classroomService.findAll().get(1),"3/3/2001","HN",true,"098354623"));
    }
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
        Student studentEdit = findByID(student.getStudentId());
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
            if (student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student findByName(String name) {
        return null;
    }
}
