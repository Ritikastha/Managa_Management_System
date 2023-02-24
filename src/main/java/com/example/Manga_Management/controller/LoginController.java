package com.example.Manga_Management.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public String getPage() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

//    return "redirect:/user/students";}

        @PostMapping("/logout")
        public String logout (Authentication authentication){
            if (authentication.isAuthenticated()) {
                SecurityContextHolder.clearContext();
            }
            return "redirect:/user/login";
        }
    }
