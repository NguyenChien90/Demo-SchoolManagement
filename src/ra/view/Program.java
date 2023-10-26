package ra.view;

import ra.config.Config;
import ra.constant.Role;
import ra.model.User;

public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }

    public void start() {
        System.out.println("Chương trình quản lý sinh viên");
        System.out.println("Hãy đăng nhập hoặc đăng ký để sử dụng hệ thống");

        int choice;
        do {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn (0/1/2) ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    LoginView loginView = new LoginView();
                    User user;
                    if ((user = loginView.showLogin()) != null) {
                        if (user.getRole().equals(Role.ADMIN)) {
                            showAdminMenu();
                        } else {
                            showUserMenu();
                        }
                    }
                    break;
                case 2:
                    new UserView().registerUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);

    }

    public void showAdminMenu() {
        int choice;
        do {
            System.out.println("**********************ADMIN MENU************************");
            System.out.println("1. Quản lý lớp học");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Quản lý môn học");
            System.out.println("4. Quản lý điểm");
            System.out.println("5. Quản lý hồ sơ cá nhân");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn (0/1/2/3/4) ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    new ClassroomView().menuClassroom();
                    break;
                case 2:
                    new StudentView().menuStudent();
                    break;
                case 3:
                    new SubjectView().menuSubject();
                    break;
                case 4:
                    new MarkView().menuMark();
                    break;
                case 5:
                    new UserView().showCurrentUserInfo();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public void showUserMenu() {
        int choice;
        do {
            System.out.println("**********************USER MENU************************");
            System.out.println("1. Thông tin lớp học");
            System.out.println("2. Danh sách môn học hiện có");
            System.out.println("3. Quản lý môn học đã đăng ký");
            System.out.println("4. Đăng ký môn học");
            System.out.println("5. Bảng điểm cá nhân");
            System.out.println("6. Quản lý hồ sơ cá nhân");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn (0/1/2/3/4/5/6) ");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    new ClassroomView().showStudentClass();
                    break;
                case 2:
                    new SubjectView().showListSubject();
                    break;
                case 3:
                    new SubjectView().showStudentSubjects();
                    break;
                case 4:
                    new SubjectView().registerSubjects();
                    break;
                case 5:
                    System.out.println("TODO");
                    break;
                case 6:
                    new UserView().showCurrentUserInfo();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }
}
