package org.blog.blog.controllers;

import org.blog.blog.entity.User;
import org.blog.blog.storage.StorageFileNotFoundException;
import org.blog.blog.storage.StorageService;
import org.blog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("user/uploadForm")
    public String listUploadedFiles(Model model) throws IOException {
        //model.addAttribute("files", storageService
          //      .loadAll()
            //    .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile",
        // path.getFileName()
              //          .toString()).build().toString()).collect(Collectors.toList()));
        //return "uploadForm";
        model.addAttribute("view", "/user/uploadForm");
        return "base-layout";

    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = (Resource) storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @PostMapping("/user/uploadForm")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model){


        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User userEntity = this.userRepository.findByEmail(user.getUsername());
        userEntity.setAvatarPath("/upload-dir/"+file.getOriginalFilename());

        this.userRepository.saveAndFlush(userEntity);

        storageService.store(file);

        model.addAttribute("view", "user/uploadForm");
        redirectAttributes.addFlashAttribute("message", "You succesfully uploaded "+file.getOriginalFilename()+"!");
        //return "uploadForm";
        // return "base-layout";
        return "redirect:/profile";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
