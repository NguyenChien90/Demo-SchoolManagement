package ra.view;

import ra.config.Config;
import ra.config.Util;
import ra.constant.Role;
import ra.constant.Status;
import ra.model.User;
import ra.service.user.UserServiceIMPL;

import static ra.constant.Role.*;

public class UserView {
    private UserServiceIMPL userService;

    public UserView() {
        userService = new UserServiceIMPL();
    }
    public void registerUser() {
        User user = new User();
        System.out.println("Hãy nhập vào thông tin user");
        System.out.println("username:");
        user.setUsername(Config.scanner().nextLine());
        System.out.println("password:");
        user.setPassword(Config.scanner().nextLine());
        System.out.println("Nhập vào role bạn muốn đăng ký (ADMIN/USER):");
        Role role = Util.validateRoleInput(Config.scanner().nextLine());
        while (role == null) {
            System.out.println("Nhập vào sai, role chỉ có thể là ADMIN hoặc USER");
            role = Util.validateRoleInput(Config.scanner().nextLine());
        }
        user.setRole(role);
        user.setStatus(Status.ACTIVE);
        user.setId(userService.getNewId());

        userService.save(user);

        System.out.println("Đăng ký thành công");
    }

    public void showCurrentUserInfo() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            System.err.println("Có lỗi xảy ra khi lấy thông tin user đăng nhập, hãy thử lại");
        } else {
            System.out.println("Thông tin người dùng đang đăng ký");
            System.out.println(currentUser);
        }
    }
}
