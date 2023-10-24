package ra.service.classroom;

import ra.model.Classroom;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {

    static List<Classroom> classroomList = new ArrayList<>();
    static {
        classroomList.add(new Classroom(1,"C001",true));
        classroomList.add(new Classroom(2,"C002",true));
        classroomList.add(new Classroom(3,"C003",true));
    }


    @Override
    public List<Classroom> findAll() {
        return classroomList;
    }

    @Override
    public void save(Classroom classroom) {
        classroomList.add(classroom);
    }

    @Override
    public void update(Classroom classroom) {
        Classroom classroomEdit = findByID(classroom.getClassroomId());
        classroomEdit.setClassroomName(classroom.getClassroomName());
        classroomEdit.setStatus(classroom.isStatus());
    }

    @Override
    public void delete(int id) {
        //        classroomList.remove(findById(id)); viết tắt
        Classroom classroomDelete = findByID(id); //viết rõ ràng
        classroomList.remove(classroomDelete);

    }

    @Override
    public Classroom findByID(int id) {
        for (Classroom classroom : classroomList) {
            if (classroom.getClassroomId() == id) {
                return classroom;
            }
        }
        return null;
    }
}
