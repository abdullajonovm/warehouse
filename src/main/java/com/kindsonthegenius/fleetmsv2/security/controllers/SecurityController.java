package com.kindsonthegenius.fleetmsv2.security.controllers;

import com.kindsonthegenius.fleetmsv2.playload.LoginDTO;
import com.kindsonthegenius.fleetmsv2.reports.repository.TruckRepository;
import com.kindsonthegenius.fleetmsv2.security.CurrentUser;
import com.kindsonthegenius.fleetmsv2.security.JwtProvider;
import com.kindsonthegenius.fleetmsv2.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    TruckRepository truckRepository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("truck", truckRepository.findFirstByOrderByIdDesc());
        System.out.println(truckRepository.findFirstByOrderByIdDesc());
        return "security/login";
    }

//    @PostMapping("/login")
//    public String login(@RequestBody LoginDTO loginDTO){
//        String token = jwtProvider.generateToken(loginDTO.getUsername());
//        System.out.println(token);
//        return "redirect:/index";
//    }

    @GetMapping("/register")
    public String register() {
        return "security/register";
    }

    @RequestMapping("/index")
    public String homePage(@CurrentUser User user) {
//        String token = jwtProvider.generateToken(user.getUsername());
        System.out.println(user);
        return "index";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
