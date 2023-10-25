package ra.service.classroom;

import ra.constant.FileName;
import ra.model.Classroom;
import ra.repo.FileRepository;

import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {
    private FileRepository<Classroom, Integer> classRoomRepository;

    public ClassroomServiceIMPL() {
        this.classRoomRepository = new FileRepository<>(FileName.CLASSROOM);
    }

    @Override
    public List<Classroom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public int getNewId() {
        return classRoomRepository.getNewId();
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
