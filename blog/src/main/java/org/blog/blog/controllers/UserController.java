package org.blog.blog.controllers;

import org.blog.blog.bindingModels.UserBindingModel;
import org.blog.blog.entity.Article;
import org.blog.blog.entity.Role;
import org.blog.blog.entity.User;
import org.blog.blog.repositories.RoleRepository;
import org.blog.blog.repositories.UserRepository;
import org.blog.blog.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Controller
public class UserController{
    private final StorageService storageService;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(StorageService storageService){this.storageService = storageService;}

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("view", "user/register");
                return "base-layout";
    }
    @PostMapping("/register")
    public String registerProcess(UserBindingModel userBindingModel){
        if(!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())){return "redirect:/register";}
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User(
                userBindingModel.getEmail(),
                userBindingModel.getFullName(),
                bCryptPasswordEncoder.encode(userBindingModel.getPassword()));
        Role userRole = this.roleRepository.findByName("ROLE_USER");
        user.addRole(userRole);
        this.userRepository.saveAndFlush(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("view", "user/login");
        return "base-layout";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";

    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profilePage(Model model){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("view", "user/profile");
        return "base-layout";
    }

    @GetMapping("/user/edit")
    public String edit(Model model) throws IOException{
        UserDetails userEntity = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = this.userRepository.findByEmail(userEntity.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("view", "user/edit");

        return "base-layout";
    }

    @PostMapping("/user/edit")
    public String editProcess(@RequestParam("file")MultipartFile file, Model model, UserBindingModel userBindingModel){

        UserDetails userEntity = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = this.userRepository.findByEmail(userEntity.getUsername());

        if (!StringUtils.isEmpty(userBindingModel.getPassword()) && !StringUtils.isEmpty(userBindingModel.getConfirmPassword())) {
            if (userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                user.setPassword(bCryptPasswordEncoder.encode(userBindingModel.getPassword()));
            }
        }

        user.setFullName(userBindingModel.getFullName());
        user.setEmail(userBindingModel.getEmail());

        if(file.isEmpty()){
            this.userRepository.saveAndFlush(user);
        }
        else{
            user.setAvatarPath("/upload-dir/"+file.getOriginalFilename());
            this.storageService.store(file);
            this.userRepository.saveAndFlush(user);}


        return "redirect:/profile";
    }

    @GetMapping("/user/{id}")
    public String userDetails(Model model, @PathVariable Integer id){

        User user = this.userRepository.findOne(id);

        Set<Article> articles = user.getArticles();

        model.addAttribute("user", user);
        model.addAttribute("articles", articles);
        model.addAttribute("view", "user/details");

        return "base-layout";
    }

}