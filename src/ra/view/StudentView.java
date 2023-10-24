package ra.view;

import ra.config.Config;
import ra.model.Classroom;
import ra.model.Mark;
import ra.model.Student;
import ra.service.classroom.ClassroomServiceIMPL;
import ra.service.classroom.IClassroomService;
import ra.service.mark.IMarkService;
import ra.service.mark.MarkServiceIMPL;
import ra.service.student.IStudentService;
import ra.service.student.StudentServiceIMPL;

public class StudentView {
    IStudentService studentService = new StudentServiceIMPL();
    IClassroomService classroomService = new ClassroomServiceIMPL();
    IMarkService markService = new MarkServiceIMPL();

    public void menuStudent() {
        int choice;
        do {

            System.out.println(".----------------------------STUDENT MANAGER---------------------------.");
            System.out.println("|               1. Hiển thị danh sách hoc sinh                         |");
            System.out.println("|               2. Thêm hoc sinh                                       |");
            System.out.println("|               3. Sửa thông tin học sinh                              |");
            System.out.println("|               4. Xóa học sinh                                        |");
            System.out.println("|               5. Sắp xếp học sinh theo tên                           |");
            System.out.println("|               6. Tìm kiếm học sinh theo tên hoặc lớp học             |");
            System.out.println("|               0. Quay lại                                            |");
            System.out.println("'----------------------------------------------------------------------'");

            System.out.print("Mời lựa chọn (0/1/2/3/4/5/6): ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    showListStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudentByName();
                    break;
                case 6:
                    searchStudentByNameClass();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void searchStudentByNameClass() {
        System.out.println("Mời nhập tên hoặc lớp cần tìm kiếm");
        String keySearch = Config.scanner().nextLine();
        int count = 0;
        System.out.println("DANH SACH TIM KIEM");
        for (Student student : studentService.findAll()) {
            if(student.getStudentName().contains(keySearch) || student.getClassroom().getClassroomName().contains(keySearch)){
                System.out.println(student);
                count++;
            }
        }
        System.out.printf("Tìm thấy %d sinh viên theo từ khóa vừa nhâp\n",count);
    }

    private void sortStudentByName() {
        studentService.findAll().sort((s1,s2)->s1.getStudentName().compareTo(s2.getStudentName()));
        System.out.println("Đã sắp xếp theo tên");
    }

    private void deleteStudent() {
        System.out.println("Nhập ID sinh viên cần xóa");
        int idDelete = Config.validateInt();
        for (Mark mark : markService.findAll()) {
            if (mark.getStudent().getStudentId() == idDelete) {
                System.out.println("Sinh viên đang có điểm không được xóa");
                return;
            }
        }
        Student studentDelete = studentService.findByID(idDelete);
        if (studentDelete == null){
            System.out.println("Không tồn tại sinh viên theo ID vừa nhập vào");
        }else {
            studentService.delete(idDelete);
            System.out.println("Xóa sinh viên thành công");
        }

    }

    private void editStudent() {
        System.out.println("Mời nhập ID học sinh cần sửa");
        int idEdit = Config.validateInt();
        Student studentEdit = studentService.findByID(idEdit);
        System.out.println("1.Sửa tên");
        System.out.println("2.Sửa lớp học");
        System.out.println("3.Sửa địa chỉ");
        System.out.println("4.Sửa số điện thoại");
        int choice = Config.validateInt();
        switch (choice) {
            case 1:
                System.out.println("Mời nhập tên mới: ");
                studentEdit.setStudentName(Config.scanner().nextLine());
                System.out.println("Sửa tên thành công");
                break;
            case 2:
                System.out.println("Danh sách lớp có thể chọn");
                for (int j = 0; j < classroomService.findAll().size(); j++) {
                    System.out.println((j + 1) + ". " + classroomService.findAll().get(j).getClassroomName());
                }
                System.out.println("Mời lưa chọn lớp học: ");
                while (true) {
                    int choiceEdit = Config.validateInt();
                    if (choiceEdit >= 1 && choice <= classroomService.findAll().size()) {
                        studentEdit.setClassroom(classroomService.findAll().get(choice - 1));
                        break;
                    } else {
                        System.out.println("Không có lớp theo lựa chọn , mời nhập lại ");
                    }
                }
                break;
            case 3:
                System.out.println("Mời nhập địa chỉ mới: ");
                studentEdit.setAddress(Config.scanner().nextLine());
                System.out.println("Sửa địa chỉ thành công");
                break;
            case 4:
                System.out.println("Mời nhập số điện thoại mới: ");
                studentEdit.setPhone(Config.scanner().nextLine());
                System.out.println("Sửa số đt thành công");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ mời nhập lại");
        }
        studentService.update(studentEdit);
    }

    private void addStudent() {
        System.out.println("Nhập số lượng học sinh cần thêm");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập học sinh thứ " + (i + 1) + ": ");
            Student student = new Student();
            //
            System.out.println("Nhập tên học sinh");
            student.setStudentName(Config.scanner().nextLine());
            // chọn classroom
            System.out.println("Danh sách lớp có thể chọn");
            for (int j = 0; j < classroomService.findAll().size(); j++) {
                System.out.println((j + 1) + ". " + classroomService.findAll().get(j).getClassroomName());
            }
            System.out.println("Mời lưa chọn lớp học: ");
            while (true) {
                int choice = Config.validateInt();
                if (choice >= 1 && choice <= classroomService.findAll().size()) {
                    student.setClassroom(classroomService.findAll().get(choice - 1));
                    break;
                } else {
                    System.out.println("Không có lớp theo lựa chọn , mời nhập lại ");
                }
            }
            System.out.println("Nhập ngày sinh: ");
            student.setBirthday(Config.scanner().nextLine());
            System.out.println("Nhập địa chỉ: ");
            student.setAddress(Config.scanner().nextLine());
            System.out.println("Nhập giới tính: ");
            student.setGender(Boolean.parseBoolean(Config.scanner().nextLine()));
            System.out.println("Nhập số điện thoại: ");
            student.setPhone(Config.scanner().nextLine());
            studentService.save(student);
        }
    }

    private void showListStudent() {
        System.out.println("DANH SACH HOC SINH");
        if (studentService.findAll().isEmpty()) System.out.println("Danh sách rỗng !!!");

        for (Student student : studentService.findAll()) {
            System.out.println(student);
        }
    }
}
