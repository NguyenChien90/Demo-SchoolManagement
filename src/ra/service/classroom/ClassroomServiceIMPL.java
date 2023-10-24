package ra.service.classroom;

import ra.model.Classroom;
import ra.repo.ClassRoomRepository;
import ra.repo.FileRepository;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {
    private ClassRoomRepository classRoomRepository;

    public ClassroomServiceIMPL() {
        this.classRoomRepository = new ClassRoomRepository();
    }

    @Override
    public List<Classroom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public void save(Classroom classroom) {
        classRoomRepository.save(classroom);
    }

    @Override
    public void update(Classroom classroom) {
        classRoomRepository.save(classroom);
    }

    @Override
    public void delete(int id) {
        classRoomRepository.deleteById(id);

    }

    @Override
    public Classroom findByID(int id) {
        return classRoomRepository.findById(id);
    }
}
