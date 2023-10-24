package ra.service.student;

import ra.model.Student;
import ra.service.IGeneric;

public interface IStudentService extends IGeneric<Student> {
    Student findByName(String name);
}
