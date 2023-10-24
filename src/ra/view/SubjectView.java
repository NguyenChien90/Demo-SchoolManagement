package ra.view;

import ra.config.Config;
import ra.model.Classroom;
import ra.model.Mark;
import ra.model.Student;
import ra.model.Subject;
import ra.service.mark.IMarkService;
import ra.service.mark.MarkServiceIMPL;
import ra.service.student.IStudentService;
import ra.service.subject.ISubjectService;
import ra.service.subject.SubjectServiceIMPL;

import java.util.List;

public class SubjectView {
    ISubjectService subjectService = new SubjectServiceIMPL();
    IMarkService markService = new MarkServiceIMPL();
    public void menuSubject() {
        int choice;
        do {
            System.out.println(".----------------------------SUBJECT MANAGER---------------------------.");
            System.out.println("|                    1. Hiển thị danh sách môn học                     |");
            System.out.println("|                    2. Thêm môn học mới                               |");
            System.out.println("|                    3. Sửa thông tin của lớp môn                      |");
            System.out.println("|                    4. Xóa môn học                                    |");
            System.out.println("|                    0. Quay lai                                       |");
            System.out.println("'----------------------------------------------------------------------'");

            System.out.print("Lựa chọn (1/2/3/4/5/6/7/8): ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    showListSubject();
                    break;
                case 2:
                    addSubject();
                    break;
                case 3:
                    editSubject();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void deleteSubject() {
        System.out.println("Nhập ID mon học cần xóa: ");
        int idDelete = Config.validateInt();
        List<Mark> markList = markService.findAll();
        for (Mark mark : markList) {
            if (mark.getSubject().getSubjectId() == idDelete){
                System.out.println("Mon học đã tồn tại diem không được xóa");
                return;
            }
        }
        Subject subjectDelete = subjectService.findByID(idDelete);
        if (subjectDelete == null){
            System.out.println("Môn học theo Id vừa nhập không tồn tại");
        }else {
            markService.delete(idDelete);
            System.out.println("Xóa môn học thành công");
        }

    }

    private void editSubject() {
        System.out.println("Mời nhập Id mon hoc cần sửa thông tin: ");
        int inEdit = Config.validateInt();
        Subject subjectEdit = subjectService.findByID(inEdit);
        if (subjectEdit == null){
            System.out.println("Không tìm thấy lớp theo ID vừa nhâp");
        }else {
            System.out.println(subjectEdit);
            System.out.println("Nhập tên mới: ");
            subjectEdit.setSubjectName(Config.scanner().nextLine());
            subjectService.update(subjectEdit);
        }
    }

    private void addSubject() {
        System.out.println("Nhap so luong mon hoc can them");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap mon hoc thu "+(i+1)+": ");
            Subject subject = new Subject();
            System.out.println("Nhap ten mon hoc: ");
            subject.setSubjectName(Config.scanner().nextLine());
            subjectService.save(subject);
        }
    }

    private void showListSubject() {
        System.out.println("DANH SACH MON HOC");
        if (subjectService.findAll().isEmpty()) System.out.println("Danh sách rỗng !!!");

        List<Subject> subjectList = subjectService.findAll();
        for (Subject subject : subjectList) {
            System.out.println(subject);
        }
    }
}
