package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findByFirebaseUid(@Param("firebaseUid") String firebaseUid);
    void insertUser(User user);
    void updateUser(User user);
}