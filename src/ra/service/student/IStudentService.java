package ra.service.student;

import ra.model.Student;
import ra.service.IService;

public interface IStudentService extends IService<Student> {
    Student findByName(String name);
}
