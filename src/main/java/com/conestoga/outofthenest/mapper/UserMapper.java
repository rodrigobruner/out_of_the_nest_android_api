package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    User findByFirebaseUid(@Param("firebaseUid") String firebaseUid);
    void insertUser(User user);
    void updateUser(User user);
    @Select("SELECT id, firebase_uid AS firebaseUid, name, email FROM users WHERE firebase_uid = #{firebaseUid}")
    User getUserByFirebaseUid(@Param("firebaseUid") String firebaseUid);
}