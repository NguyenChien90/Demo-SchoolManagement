package ra.config;

import ra.constant.Role;

public class Util {
    public static Role validateRoleInput(String role) {
        if (role.equals(Role.USER.name())) {
            return Role.USER;
        } else if (role.equals(Role.ADMIN.name())){
            return Role.ADMIN;
        }
        return null;
    }
}
