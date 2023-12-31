package ra.view;

import ra.config.Config;
import ra.model.Mark;
import ra.model.Subject;
import ra.service.classroom.ClassroomServiceIMPL;
import ra.service.classroom.IClassroomService;
import ra.service.mark.IMarkService;
import ra.service.mark.MarkServiceIMPL;
import ra.service.student.IStudentService;
import ra.service.student.StudentServiceIMPL;
import ra.service.subject.ISubjectService;
import ra.service.subject.SubjectServiceIMPL;

import java.util.Collections;
import java.util.Comparator;

public class MarkView {
    IMarkService markService = new MarkServiceIMPL();
    IClassroomService classroomService = new ClassroomServiceIMPL();
    ISubjectService subjectService = new SubjectServiceIMPL();
    IStudentService studentService = new StudentServiceIMPL();

    public void menuMark() {
        int choice;
        do {
            System.out.println(".------------------------------MARK MANAGER----------------------------.");
            System.out.println("|                1. Hiển thị danh sách điểm thi                        |");
            System.out.println("|                2. Thêm điểm thi cho sinh viên                        |");
            System.out.println("|                3. Sắp xếp điểm thi theo thứ tự giảm dần              |");
            System.out.println("|                4. Thay đổi điểm thi theo mã ID                       |");
            System.out.println("|                5. Xóa điểm thi theo mã ID                            |");
            System.out.println("|                6. Hiển thị điểm thi theo môn học                     |");
            System.out.println("|                7. Đánh giá học lực theo từng điểm của môn học        |");
            System.out.println("|                0. Quay lai                                           |");
            System.out.println("'----------------------------------------------------------------------'");

            System.out.print("Lựa chọn (1/2/3/4/5/6/7/8): ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    showListMark();
                    break;
                case 2:
                    addMark();
                    break;
                case 3:
                    sortMarkASC();
                    break;
                case 4:
                    editMark();
                    break;
                case 5:
                    deleteMark();
                    break;
                case 6:
                    showListMarkBySubJect();
                    break;
                case 7:
                    rankByPoinOfMark();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void rankByPoinOfMark() {
        // xắp xếp theo môn học
        Collections.sort(markService.findAll(), new Comparator<Mark>() {
            @Override
            public int compare(Mark o1, Mark o2) {
                return o1.getSubject().getSubjectName().compareTo(o2.getSubject().getSubjectName());
            }
        });
        // đánh giá theo điểm
        for (Mark mark : markService.findAll()) {
            if(mark.getPoin() >=9){
                System.out.print(mark);
                System.out.println(" - Xếp loại xuất sắc");
            }else if (mark.getPoin() >=8){
                System.out.print(mark);
                System.out.println(" - Xếp loại giỏi");
            }else if (mark.getPoin() >= 6.5) {
                System.out.print(mark);
                System.out.println(" - Xếp loại khá");
            }else if (mark.getPoin() >5) {
                System.out.print(mark);
                System.out.println(" - Xếp loại trung bình");
            }else {
                System.out.print(mark);
                System.out.println(" - Xếp loại yếu");
            }
        }
    }

    private void showListMarkBySubJect() {
        System.out.println("Danh sách các môn học");
        for (int i = 0; i < subjectService.findAll().size(); i++) {
            System.out.println((i+1)+". "+ subjectService.findAll().get(i).getSubjectName());
        }
        System.out.println("Mời lựa chọn môn học cần hiển thị điểm theo số: ");
        int choice = Config.validateInt();
        System.out.println("Danh sách điểm theo môn học");
        for (Mark mark : markService.findAll()) {
            if (mark.getSubject().getSubjectName().equals(subjectService.findAll().get(choice-1).getSubjectName())){
                System.out.println(mark);
            }
        }
    }

    private void deleteMark() {
        System.out.println("Nhập ID điểm cần xóa");
        int idDelete = Config.validateInt();
        Mark markDelete = markService.findByID(idDelete);
        if (markDelete == null){
            System.out.println("Không tồn tại điểm theo ID vừa nhập");
        }else {
            markService.delete(idDelete);
            System.out.println("Xóa điểm thành công");
        }
    }

    private void editMark() {
        System.out.println("Nhập ma ID điểm cần sửa: ");
        int idEdit = Config.validateInt();
        Mark markEdit = markService.findByID(idEdit);
        if (markEdit == null){
            System.out.println("Điểm cần sửa theo mã ID vừa nhập không tồn tại");
        }else {
            System.out.println(markEdit);
            System.out.println("Mời nhập điểm mới: ");
            markEdit.setPoin(Double.parseDouble(Config.scanner().nextLine()));
            System.out.println("Sửa điểm thành công");
        }
    }

    private void sortMarkASC() {
        Collections.sort(markService.findAll(), new Comparator<Mark>() {
            @Override
            public int compare(Mark o1, Mark o2) {
                return (int) (o2.getPoin() - o1.getPoin());
            }
        });
        System.out.println("Đã sắp xếp theo điểm thành công");
    }

    private void addMark() {
        System.out.println("Mời nhập số lương điểm thi cần nhập");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập điểm thi thứ " + (i + 1));
            Mark mark = new Mark();
            // chọn sinh viên nhập điểm
            System.out.println("Danh sách sinh viên chọn lựa");
            for (int j = 0; j < studentService.findAll().size(); j++) {
                System.out.println((j + 1) + ". " + studentService.findAll().get(j).getStudentName());
            }
            System.out.println("Mời chọn");
            while (true) {
                int choice = Config.validateInt();
                if (choice >= 0 && choice <= studentService.findAll().size()) {
                    mark.setStudent(studentService.findAll().get(choice - 1));
                    break;
                } else {
                    System.out.println("Lựa chọn không đúng mời chọn lại ");
                }
            }

            //chon môn học
            System.out.println("Danh sách môn học cần chọn");
            for (int j = 0; j < subjectService.findAll().size(); j++) {
                System.out.println((j + 1) + ". " + subjectService.findAll().get(j).getSubjectName());
            }
            System.out.println("Mời chọn");
            while (true) {
                int choice = Config.validateInt();
                if (choice >= 0 && choice <= subjectService.findAll().size()) {
                    mark.setSubject(subjectService.findAll().get(choice - 1));
                    break;
                } else {
                    System.out.println("Lựa chọn không đúng mời chọn lại ");
                }
            }
            // nhập điểm cho điểm thi
            System.out.println("Mời nhập điểm");
            mark.setPoin(Double.parseDouble(Config.scanner().nextLine()));
            // gọi đến phương thức save của MarkServiceIMPL để lưu đối tượng mark vừa nhập
            // thông tin vào listMark
            markService.save(mark);
        }
    }

    private void showListMark() {
        if (markService.findAll().isEmpty()) System.out.println("Danh sách rỗng !!!");

        System.out.println("DANH SACH DIEM");
        for (Mark mark : markService.findAll()) {
            System.out.println(mark);
        }
    }
}
