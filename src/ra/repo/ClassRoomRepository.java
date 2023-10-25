package ra.repo;

import ra.model.Classroom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomRepository extends FileRepository<Classroom, Integer> {

    public ClassRoomRepository(String fileName) {
        super(fileName);
    }
}
