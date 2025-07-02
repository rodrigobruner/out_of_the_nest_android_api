package com.conestoga.outofthenest.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private List<FamilyMemberDTO> familyMembers;
}
