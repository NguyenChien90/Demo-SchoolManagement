package ra.repo;

import ra.model.Entity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public interface FileRepository <T extends Entity, ID extends Number> {
    List<T> findAll();

    boolean save(T t);

    T findById(ID id);

    boolean deleteById(ID id);

    default boolean saveToFile(List<T> list, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
            outputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
