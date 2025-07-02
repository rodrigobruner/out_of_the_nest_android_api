package com.conestoga.outofthenest.controller;

import com.conestoga.outofthenest.dto.UserDTO;
import com.conestoga.outofthenest.model.FamilyMember;
import com.conestoga.outofthenest.model.User;
import com.conestoga.outofthenest.mapper.FamilyMemberMapper;
import com.conestoga.outofthenest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();

        currentUser.setName(dto.getName());
        currentUser.setEmail(dto.getEmail());
        userMapper.updateUser(currentUser);

        familyMemberMapper.deleteByUserId(currentUser.getId());

        List<FamilyMember> members = dto.getFamilyMembers().stream().map(f -> {
            FamilyMember m = new FamilyMember();
            m.setUserId(currentUser.getId());
            m.setType(f.getType());
            m.setAge(f.getAge());
            return m;
        }).toList();

        familyMemberMapper.insertFamilyMembers(members);

        return ResponseEntity.ok("用户信息已更新");
    }
}

