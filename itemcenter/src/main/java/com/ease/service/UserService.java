package com.ease.service;

import com.ease.model.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有未删除用户
     *
     * @return
     */
    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);

    String getUserByName(String userName);
}
