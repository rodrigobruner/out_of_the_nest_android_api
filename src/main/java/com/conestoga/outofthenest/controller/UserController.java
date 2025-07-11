package com.conestoga.outofthenest.controller;

import com.conestoga.outofthenest.dto.UserDTO;
import com.conestoga.outofthenest.model.FamilyMember;
import com.conestoga.outofthenest.model.User;
import com.conestoga.outofthenest.mapper.FamilyMemberMapper;
import com.conestoga.outofthenest.mapper.UserMapper;
import com.conestoga.outofthenest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

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

        return ResponseEntity.ok("User info updated successfully");
    }
    @GetMapping("/getUser")
    public User getUser(@RequestParam String id) {
        return userService.getUser(id);
    }
}

