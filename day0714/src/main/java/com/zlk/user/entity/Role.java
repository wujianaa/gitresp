package com.zlk.user.entity;

public class Role {
    /**roleId*/
    private int roleId;
    /**roleName*/
    private String roleName;
    /**roleDesc*/
    private String roleDesc;
   private UserRole userRole;
    public Role() {
    }

    public Role(int roleId, String roleName, String roleDesc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
