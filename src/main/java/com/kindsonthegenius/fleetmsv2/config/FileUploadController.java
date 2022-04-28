package com.kindsonthegenius.fleetmsv2.config;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.kindsonthegenius.fleetmsv2.security.CurrentUser;
import com.kindsonthegenius.fleetmsv2.security.SpringSecurityAuditorAware;
import com.kindsonthegenius.fleetmsv2.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

//    @Autowired
//    SpringSecurityAuditorAware springSecurityAuditorAware;

    private final String UPLOAD_DIRECTORY = "D:\\fleed";



    @GetMapping("/profile")
    public String uploadFileForm(@CurrentUser User user, Model model) {
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
            throws IOException {
        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please select a file to upload.");
            return "redirect:/profile";
        }

        Path path = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        Files.write(path, file.getBytes());

        redirectAttributes.addFlashAttribute("successMessage", "File upload successfully, uploaded file name: " + file.getOriginalFilename());
        return "redirect:/profile";
    }

}