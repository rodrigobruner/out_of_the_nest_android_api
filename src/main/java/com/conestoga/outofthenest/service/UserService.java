package com.conestoga.outofthenest.service;

import com.conestoga.outofthenest.model.User;
import com.conestoga.outofthenest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getOrCreateUser(String firebaseUid, String email) {
        User user = userMapper.findByFirebaseUid(firebaseUid);
        if (user == null) {
            user = new User();
            user.setFirebaseUid(firebaseUid);
            user.setEmail(email);
            userMapper.insertUser(user);
        }
        return user;
    }
    public User getUser(String firebaseUid) {
        return userMapper.getUserByFirebaseUid(firebaseUid);
    }
}
