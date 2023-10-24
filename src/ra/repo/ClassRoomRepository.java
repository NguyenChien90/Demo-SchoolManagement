package ra.repo;

import ra.model.Classroom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomRepository implements FileRepository<Classroom, Integer> {
    private File file;

    public ClassRoomRepository() {
        File dataDir = new File("data");
        dataDir.mkdir();
        file = new File("data/classroom.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Có lỗi xảy ra khi tạo mới file classroom.dat");
        }
    }
    @Override
    public List<Classroom> findAll() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            List<Classroom> classrooms = (List<Classroom>) inputStream.readObject();
            inputStream.close();

            return classrooms;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(Classroom e) {
        List<Classroom> classrooms = findAll();
        for (Classroom classroom : classrooms) {
            if (classroom.getId().equals(e.getId())) {
                int indexOf = classrooms.indexOf(classroom);
                classrooms.set(indexOf, e);
                return saveToFile(classrooms, this.file);
            }
        }
        classrooms.add(e);
        return saveToFile(classrooms, file);
    }

    @Override
    public Classroom findById(Integer id) {
        List<Classroom> classrooms = findAll();
        for (Classroom classroom : classrooms) {
            if (classroom.getId().equals(id)) {
                return classroom;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        List<Classroom> classrooms = findAll();
        for (Classroom classroom : classrooms) {
            if (classroom.getId().equals(id)) {
                classrooms.remove(classroom);
                return saveToFile(classrooms, file);
            }
        }
        return false;
    }
}
