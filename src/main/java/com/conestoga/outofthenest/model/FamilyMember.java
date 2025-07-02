package com.conestoga.outofthenest.model;

import lombok.Data;

@Data
public class FamilyMember {
    private Long id;
    private Long userId;
    private String type;  // MAN, WOMAN, BOY, GIRL, OTHER
    private int age;
}