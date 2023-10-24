package ra.service.mark;

import ra.model.Classroom;
import ra.model.Mark;
import ra.service.student.IStudentService;
import ra.service.student.StudentServiceIMPL;
import ra.service.subject.ISubjectService;
import ra.service.subject.SubjectServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class MarkServiceIMPL implements IMarkService {
    static ISubjectService subjectService = new SubjectServiceIMPL();
    static IStudentService studentService = new StudentServiceIMPL();
    static List<Mark> markList = new ArrayList<>();
    static {
        markList.add(new Mark(1,studentService.findAll().get(0),subjectService.findAll().get(0),9));
        markList.add(new Mark(2,studentService.findAll().get(0),subjectService.findAll().get(1),9.5));
        markList.add(new Mark(3,studentService.findAll().get(0),subjectService.findAll().get(2),8));
        markList.add(new Mark(4,studentService.findAll().get(1),subjectService.findAll().get(0),7));
        markList.add(new Mark(5,studentService.findAll().get(1),subjectService.findAll().get(1),6.5));
        markList.add(new Mark(6,studentService.findAll().get(1),subjectService.findAll().get(2),5));
        markList.add(new Mark(7,studentService.findAll().get(2),subjectService.findAll().get(0),4));
        markList.add(new Mark(8,studentService.findAll().get(2),subjectService.findAll().get(1),5));
        markList.add(new Mark(9,studentService.findAll().get(2),subjectService.findAll().get(2),6));
    }
    @Override
    public List<Mark> findAll() {
        return markList;
    }

    @Override
    public void save(Mark mark) {
        markList.add(mark);
    }

    @Override
    public void update(Mark mark) {
        Mark markEdit = findByID(mark.getMarkId());
        markEdit.setPoin(mark.getPoin());
    }

    @Override
    public void delete(int id) {
        markList.remove(findByID(id));
    }

    @Override
    public Mark findByID(int id) {
        for (Mark mark : markList) {
            if (mark.getMarkId() == id) {
                return mark;
            }
        }
        return null;
    }
}
