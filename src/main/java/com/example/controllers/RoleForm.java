package com.example.controllers;

import lombok.Data;

import java.util.List;

@Data
public class RoleForm {
    private String name;
    private List<String> authorities;
}
