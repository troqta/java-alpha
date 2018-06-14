package org.blog.blog.controllers;

import org.blog.blog.bindingModels.ArticleBindingModel;
import org.blog.blog.bindingModels.CommentBindingModel;
import org.blog.blog.entity.*;
import org.blog.blog.repositories.*;
import org.blog.blog.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ArticleController {
    private final StorageService storageService;
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public ArticleController(StorageService storageService){this.storageService=storageService;}



    @GetMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model) throws IOException{

        List<Category> categories = this.categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("view", "article/create");
        return "base-layout";

    }
    @PostMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String createProcess(@RequestParam("file") MultipartFile file, ArticleBindingModel articleBindingModel){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User userEntity = this.userRepository.findByEmail(user.getUsername());
        Category category = this.categoryRepository.findOne(articleBindingModel.getCategoryId());
        HashSet<Tag> tags = this.findTagsFromString(articleBindingModel.getTagString());
        String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(System.currentTimeMillis()));


        if(file.isEmpty()){
            String imagePath = "/upload-dir/default.jpg";
            Article articleEntity = new Article(
                    articleBindingModel.getTitle(),
                    articleBindingModel.getContent(),
                    userEntity,
                    category,
                    tags,
                    imagePath,
                    date
            );
            this.articleRepository.saveAndFlush(articleEntity);

        }
        else{
            String imagePath="/upload-dir/"+file.getOriginalFilename();
            Article articleEntity = new Article(
                    articleBindingModel.getTitle(),
                    articleBindingModel.getContent(),
                    userEntity,
                    category,
                    tags,
                    imagePath,
                    date
            );
            this.articleRepository.saveAndFlush(articleEntity);
            storageService.store(file);}

        return "redirect:/";
    }
    @GetMapping("/article/{id}")
    public String details(Model model, @PathVariable Integer id){
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }
        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)){
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            User entityUser = this.userRepository.findByEmail(principal.getUsername());


            model.addAttribute("user", entityUser);

        }
        Article article = this.articleRepository.findOne(id);
        List<Comment> comments = article.getComments();



        model.addAttribute("comments", comments);
        model.addAttribute("article", article);
        model.addAttribute("view", "article/details");

        return "base-layout";
    }

    @PostMapping("/article/{id}")
    public String createComment(@PathVariable Integer id, CommentBindingModel commentBindingModel){
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }
        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            User entityUser = this.userRepository.findByEmail(principal.getUsername());

            Article article = this.articleRepository.findOne(id);

            List<Comment> comments = article.getComments();

            Comment comment = new Comment(entityUser, commentBindingModel.getContent(), article, entityUser.getFullName());

            this.commentRepository.saveAndFlush(comment);
        }

        return "redirect:/article/{id}";
    }

    @GetMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String edit(@PathVariable Integer id, Model model) throws IOException{
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }
        Article article = this.articleRepository.findOne(id);

        if(!isUserAuthorOrAdmin(article)){
            return "redirect:/article/"+id;
        }
        String tagString = article.getTags().stream()
                .map(Tag :: getName)
                .collect(Collectors.joining(", "));
        List<Category> categories = this.categoryRepository.findAll();

        model.addAttribute("view", "article/edit");
        model.addAttribute("article", article);
        model.addAttribute("categories", categories);
        model.addAttribute("tags", tagString);

        return "base-layout";
    }

    @PostMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editProcess(@RequestParam("file") MultipartFile file, @PathVariable Integer id, ArticleBindingModel articleBindingModel){
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }

        Article article = this.articleRepository.findOne(id);

        if(!isUserAuthorOrAdmin(article)){
            return "redirect:/article/"+id;
        }
        Category category = this.categoryRepository.findOne(articleBindingModel.getCategoryId());
        HashSet<Tag> tags = this.findTagsFromString(articleBindingModel.getTagString());


        article.setContent(articleBindingModel.getContent());
        article.setTitle(articleBindingModel.getTitle());
        article.setCategory(category);
        article.setTags(tags);
        if(file.isEmpty()){
            this.articleRepository.saveAndFlush(article);
        }
        else{
        article.setImagePath("/upload-dir/"+file.getOriginalFilename());
        this.articleRepository.saveAndFlush(article);
        this.storageService.store(file);}

        return "redirect:/article/"+article.getId();

    }
    @GetMapping("/article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String delete(Model model, @PathVariable Integer id){
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }
        Article article = this.articleRepository.findOne(id);

        if(!isUserAuthorOrAdmin(article)){
            return "redirect:/article/"+id;
        }

        model.addAttribute("article", article);
        model.addAttribute("view", "article/delete");

        return "base-layout";
    }
    @PostMapping("/article/delete/{id}")
    @PreAuthorize("isAuthenticuated()")
    public String deleteProcess(@PathVariable Integer id){
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }
        Article article = this.articleRepository.findOne(id);
        if(!isUserAuthorOrAdmin(article)){
            return "redirect:/article/"+id;
        }

        this.articleRepository.delete(article);
        return "redirect:/";
    }

    private boolean isUserAuthorOrAdmin(Article article){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User userEntity = this.userRepository.findByEmail(user.getUsername());
        return userEntity.isAdmin() || userEntity.isAuthor(article);
    }

    private HashSet<Tag> findTagsFromString(String tagString){
        HashSet<Tag> tags = new HashSet<>();
        String[] tagNames = tagString.split(",\\s*");
        for(String tagName : tagNames){
            Tag currentTag = this.tagRepository.findByName(tagName);

            if(currentTag == null){
                currentTag = new Tag(tagName);
                this.tagRepository.saveAndFlush(currentTag);
            }
            tags.add(currentTag);
        }
        return tags;
    }
}
