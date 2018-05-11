package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_roles", schema = "sampleshop", catalog = "")
public class UserRolesEntity
{
    private int userRoleId;
    private String username;
    private String role;

    @Id
    @Column(name = "user_role_id", nullable = false)
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 50)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRolesEntity that = (UserRolesEntity) o;
        return userRoleId == that.userRoleId &&
                Objects.equals(username, that.username) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, username, role);
    }
}
