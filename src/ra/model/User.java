package ra.model;

import ra.constant.Role;
import ra.constant.Status;

public class User extends Entity<Integer> {
    private String username;
    private String password;

    private Role role;

    private Status status;

    public User() {

    }

    public User(String username, String password, Role role, Status status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User(Integer id, String username, String password, Role role, Status status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        User o = (User) obj;
        return this.username.equals(o.username) && this.password.equals(o.password)
                && this.role.equals(o.role) && this.status.equals(o.status);
    }
}
