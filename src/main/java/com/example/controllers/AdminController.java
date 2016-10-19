package com.example.controllers;

import com.example.model.Permission;
import com.example.repositories.PermissionRepository;
import com.example.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping("admin")
@Controller
@AllArgsConstructor
public class AdminController {
    private PermissionRepository permissionRepository;
    private RoleRepository roleRepository;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("permissions",
                StreamSupport.stream(permissionRepository.findAll().spliterator(), false)
                        .map(i -> i.getName())
                        .collect(Collectors.toList()));

        model.addAttribute("roles",
                StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                        .map(i -> i.getName())
                        .collect(Collectors.toList()));

        return "admin-page";
    }
}
