package ra.service.mark;

import ra.model.Mark;

import java.util.ArrayList;
import java.util.List;

public class MarkServiceIMPL implements IMarkService {
    static List<Mark> markList = new ArrayList<>();
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

    }

    @Override
    public void delete(int id) {
        markList.remove(findByID(id));
    }

    @Override
    public Mark findByID(int id) {
        return null;
    }
}
