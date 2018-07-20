package org.blog.blog.controllers;

import org.blog.blog.entity.Article;
import org.blog.blog.entity.Category;
import org.blog.blog.repositories.ArticleRepository;
import org.blog.blog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Category> categories = this.categoryRepository.findAll();

        model.addAttribute("view", "home/index");
        model.addAttribute("categories", categories);

        return "base-layout";
    }

    @RequestMapping("/error/403")
    public String accessDenied(Model model) {
        model.addAttribute("view", "error/403");
        return "base-layout";
    }

    @RequestMapping("/error/404")
    public String pageNotFound(Model model) {
        model.addAttribute("view", "error/404");
        return "base-layout";
    }

    @GetMapping("/category/{id}")
    public String listArticles(Model model, @PathVariable Integer id, HttpServletRequest request) {

        if (!this.categoryRepository.exists(id)) {
            return "redirect:/";
        }


        Category category = this.categoryRepository.findOne(id);
        //Set<Article> articles = category.getArticles();

        // String page = request.getParameter("page");
        PagedListHolder<Article> articles = new PagedListHolder<>(category.getArticles());
        articles.setPageSize(5);
        if (request.getParameter("page") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            articles.setPage(page);
        }
        //if("previous".equals(page)){
        //  articles=(PagedListHolder<Article>) request.getSession().getAttribute("pagedArticleList");
        // articles.previousPage();
        //} else if("next".equals(page)){
        //   articles=(PagedListHolder<Article>) request.getSession().getAttribute("pagedArticlList");
        //  articles.nextPage();
        //} else {
        //   articles = new PagedListHolder<Article>(category.getArticles());
        //  articles.setPageSize(5);
        //  request.getSession().setAttribute("pagedArticleList", articles);
        // }

        model.addAttribute("articles", articles);
        model.addAttribute("category", category);
        model.addAttribute("view", "home/list-articles");

        return "base-layout";
    }
}
