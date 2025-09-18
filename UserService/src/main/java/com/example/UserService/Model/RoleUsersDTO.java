package com.example.UserService.Model;

import java.util.List;

public class RoleUsersDTO {
    private Long roleId;
    private List<Long> userIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
