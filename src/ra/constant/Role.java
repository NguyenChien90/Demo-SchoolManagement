package ra.constant;

import java.io.Serializable;

public enum Role implements Serializable {
    ADMIN("admin"), USER("user");
    private String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
