package ra.service.subject;

import ra.constant.FileName;
import ra.model.Subject;
import ra.repo.FileRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectServiceIMPL implements ISubjectService {
    private FileRepository<Subject, Integer> subjectRepository = new FileRepository<>(FileName.SUBJECT);

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void update(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void delete(int id) {
        subjectRepository.deleteById(id);

    }

    @Override
    public Subject findByID(int id) {
        return subjectRepository.findById(id);
    }

    @Override
    public int getNewId() {
        return subjectRepository.getNewId();
    }
}
