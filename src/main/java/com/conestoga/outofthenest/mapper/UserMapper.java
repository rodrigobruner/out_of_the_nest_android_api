package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.FamilyMember;
import com.conestoga.outofthenest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByFirebaseUid(@Param("firebaseUid") String firebaseUid);
    void insertUser(User user);
    void updateUser(User user);
    @Select("SELECT id, firebase_uid AS firebaseUid, name, email FROM users WHERE firebase_uid = #{firebaseUid}")
    User getUserByFirebaseUid(@Param("firebaseUid") String firebaseUid);

    @Select("SELECT * FROM users WHERE firebase_uid = #{userId}")
    User getUserById(String userId);

    @Select("SELECT * FROM family_members WHERE user_id = #{userId}")
    List<FamilyMember> getFamilyMembersByUserId(String userId);
}