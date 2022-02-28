package com.ngimbis.labs.watchthis.service;

import com.ngimbis.labs.watchthis.domain.Role;
import com.ngimbis.labs.watchthis.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}

