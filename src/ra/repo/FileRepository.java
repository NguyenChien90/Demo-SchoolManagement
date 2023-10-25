package ra.repo;

import ra.model.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository <T extends Entity, ID extends Number> {
    private String fileName;

    public FileRepository(String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Tạo file sau đây bị lỗi: " + fileName);
        }
    }

    public List<T> findAll() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            List<T> list = (List<T>) inputStream.readObject();
            inputStream.close();

            return list;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return new ArrayList<>();
        }
    }

    public int getNewId() {
        List<T> list = findAll();
        int maxId = list.isEmpty() ? 0 : list.get(list.size() - 1).getId().intValue();
        return maxId + 1;
    }

    public boolean save(T t) {
        List<T> list = findAll();
        for (T e : list) {
            if (t.getId().equals(e.getId())) {
                int indexOf = list.indexOf(e);
                list.set(indexOf, e);
                return saveToFile(list, this.fileName);
            }
        }
        list.add(t);
        return saveToFile(list, this.fileName);
    }

    public boolean saveOnlyOne(T t) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(t);
            outputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public T findById(ID id) {
        List<T> list = findAll();
        for (T t : list) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public boolean deleteById(ID id) {
        List<T> list = findAll();
        for (T t : list) {
            if (t.getId().equals(id)) {
                list.remove(t);
                return saveToFile(list, this.fileName);
            }
        }
        return false;
    }

    protected boolean saveToFile(List<T> list, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
            outputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
