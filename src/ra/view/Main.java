package ra.view;

import ra.config.Config;

public class Main {
    public static void main(String[] args) {
//        Main main = new Main();
//        main.menu();
         new Main().menu();// tương đương 2 dòng trên tạo đối tượng lớp Main để gọi đến phương thức
    }
    public void menu() {
            int choice;
            do {
                System.out.println(".---------------------------------MENU---------------------------------.");
                System.out.println("|                         1. Quản lý lớp học                           |");
                System.out.println("|                         2. Quản lý sinh viên                         |");
                System.out.println("|                         3. Quản lý môn học                           |");
                System.out.println("|                         4. Quản lý điểm                              |");
                System.out.println("|                         0. Thoát                                     |");
                System.out.println("'----------------------------------------------------------------------'");
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
