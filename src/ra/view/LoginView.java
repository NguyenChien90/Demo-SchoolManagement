package ra.view;

import ra.config.Config;
import ra.model.User;
import ra.service.user.UserServiceIMPL;

public class LoginView {
    private UserServiceIMPL userService;

    public LoginView() {
        userService = new UserServiceIMPL();
    }

    public User showLogin() {
        System.out.println("Thực hiện đăng nhập");
        System.out.println("username:");
        String username = Config.scanner().nextLine();
        System.out.println("password:");
        String password = Config.scanner().nextLine();
        User loginUser = userService.login(username, password);
        if (loginUser != null) {
            System.out.println("Đăng nhập thành công!");
            return loginUser;
        } else {
            System.out.println("Đăng nhập thất bại, hãy thử lại");
            return null;
        }
    }
}
