package com.conestoga.outofthenest.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;
    private String firebaseUid;
    private String name;
    private String email;
    private List<FamilyMember> familyMembers;
}