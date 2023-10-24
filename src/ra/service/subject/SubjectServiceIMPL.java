package ra.service.subject;

import ra.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectServiceIMPL implements ISubjectService {
    static List<Subject> subjectList = new ArrayList<>();
    @Override
    public List<Subject> findAll() {
        return subjectList;
    }

    @Override
    public void save(Subject subject) {
        subjectList.add(subject);
    }

    @Override
    public void update(Subject subject) {
        Subject subjectEdit = findByID(subject.getId());
        subjectEdit.setSubjectName(subject.getSubjectName());
    }

    @Override
    public void delete(int id) {
        Subject subjectDelete = findByID(id);
        subjectList.remove(subjectDelete);

    }

    @Override
    public Subject findByID(int id) {
        for (Subject subject : subjectList) {
            if (subject.getId() == id){
                return subject;
            }
        }
        return null;
    }
}
