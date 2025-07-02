package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.FamilyMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FamilyMemberMapper {
    void insertFamilyMembers(@Param("members") List<FamilyMember> members);
    void deleteByUserId(@Param("userId") Long userId);
}