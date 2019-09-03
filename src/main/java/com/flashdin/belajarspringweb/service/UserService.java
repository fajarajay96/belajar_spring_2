package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    List<User> findByUsername(User param);

    List<User> login(User param);

    List<User> findByUsernameAndPassword(User param);

    User findByUsername(String username);
}
