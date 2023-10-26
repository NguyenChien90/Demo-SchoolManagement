package ra.view;

import ra.config.Config;
import ra.model.Classroom;
import ra.model.Student;
import ra.model.User;
import ra.service.classroom.IClassroomService;
import ra.service.classroom.ClassroomServiceIMPL;
import ra.service.student.StudentServiceIMPL;
import ra.service.user.UserServiceIMPL;

import java.util.List;

public class ClassroomView {
    IClassroomService classroomService = new ClassroomServiceIMPL();
    StudentServiceIMPL studentService = new StudentServiceIMPL();

    UserServiceIMPL userService = new UserServiceIMPL();

    public void menuClassroom() {
        int choice;
        do {
            System.out.println("**********************CLASSROOM MANAGER************************");
            System.out.println("1. Hiển thị danh sách lớp học");
            System.out.println("2. Thêm lớp học mới");
            System.out.println("3. Sửa thông tin của lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("0. Quay lai");
            System.out.print("Lựa chọn (1/2/3/4/5/6/7/8): ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    showListClassroom();
                    break;
                case 2:
                    addClassroom();
                    break;
                case 3:
                    editClassroom();
                    break;
                case 4:
                    deleteClassroom();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void deleteClassroom() {
        System.out.println("Nhập ID lớp học cần xóa: ");
        int idDelete = Config.validateInt();
        List<Student> studentList = studentService.findAll();
        for (Student student : studentList) {
            if (student.getClassroom().getId() == idDelete) {
                System.out.println("Lớp học đã tồn tại sinh viên không được xóa");
                return;
            }
        }
        Classroom classroomDelete = classroomService.findByID(idDelete);
        if (classroomDelete == null) {
            System.out.println("Lớp học theo ID vừa nhập không tồn tại");
        } else {
            classroomService.delete(idDelete);
            System.out.println("Xóa lớp học thành công");
        }

    }

    private void editClassroom() {
        System.out.println("Mời nhập Id lớp cần sửa thông tin: ");
        int inEdit = Config.validateInt();
        Classroom classroomEdit = classroomService.findByID(inEdit);
        if (classroomEdit == null) {
            System.out.println("Không tìm thấy lớp theo ID vừa nhâp");
        } else {
            System.out.println(classroomEdit);
            int choice;
            System.out.println("Mời chọn thông tin cần sửa");
            System.out.println("1.Sửa tên");
            System.out.println("2.Sửa trạng thái");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên mới: ");
                    classroomEdit.setClassroomName(Config.scanner().nextLine());
                    break;
                case 2:
                    classroomEdit.setStatus(!classroomEdit.isStatus());
                    System.out.println("Đã thay đổi trạng thái");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ mời nhập lại");
            }
            classroomService.update(classroomEdit);
        }


    }

    private void addClassroom() {
        System.out.println("Nhap so luong lop hoc can them");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap lop hoc thu " + (i + 1) + ": ");
            Classroom classroom = new Classroom();
            classroom.setId(classroomService.getNewId());
            System.out.println("Nhap lop hoc: ");
            classroom.setClassroomName(Config.scanner().nextLine());
            System.out.println("Nhap trang thai lop true/fale");
            classroom.setStatus(Boolean.parseBoolean(Config.scanner().nextLine()));
            classroomService.save(classroom);
        }
    }

    private void showListClassroom() {
        System.out.println("DANH SACH LOP HOC");
        if (classroomService.findAll().isEmpty()) System.out.println("Danh sách rỗng !!!");

        List<Classroom> classroomList = classroomService.findAll();
        for (Classroom classroom : classroomList) {
            System.out.println(classroom);
        }
    }

    public void showStudentClass() {
        User user = userService.getCurrentUser();
        Student student = studentService.findByUserId(user.getId());
        if (student != null) {
            System.out.println("Thông tin lớp hiện tại của học sinh:");
            System.out.println(student.getClassroom());
        } else {
            System.out.println("Không có thông tin lớp học hiện tại của học sinh");
        }
    }

}
