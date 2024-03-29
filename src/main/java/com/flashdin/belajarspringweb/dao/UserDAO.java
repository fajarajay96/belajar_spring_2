package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {

    List<User> findByUsername(User param);
     List<User> login(User param);
     List<User> findByUsernameAndPassword(User param);
     User findByUsername(String username);
}
