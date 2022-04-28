package com.kindsonthegenius.fleetmsv2;

import com.kindsonthegenius.fleetmsv2.reports.repository.TruckRepository;
import com.kindsonthegenius.fleetmsv2.security.CurrentUser;
import com.kindsonthegenius.fleetmsv2.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @Autowired
    TruckRepository truckRepository;

    @GetMapping("/index")
    public String goHome(Model model, @CurrentUser User user){
        model.addAttribute("truck", truckRepository.findFirstByOrderByIdDesc());
        System.out.println(truckRepository.findFirstByOrderByIdDesc());
        System.out.println(user);
        model.addAttribute("employee", truckRepository.findFirstByOrderByIdDesc().getEmployeeCount());
        return "index";
    }



    @GetMapping("hr")
    public String hr(){
        return "/hr/index";
    }

    @GetMapping("fleet")
    public String fleet(){
        return "/fleet/index";
    }

    @GetMapping("accounts")
    public String accounts(){
        return "/accounts/index";
    }

    @GetMapping("payroll")
    public String payroll(){
        return "/payroll/index";
    }

    @GetMapping("helpdesk")
    public String helpdesk(){
        return "/helpdesk/index";
    }

    @GetMapping("parameters")
    public String parameters(){
        return "/parameters/index";
    }

    @GetMapping("reports")
    public String reports(){
        return "/reports/index";
    }

    @GetMapping("security")
    public String security(){
        return "/security/index";
    }

}
