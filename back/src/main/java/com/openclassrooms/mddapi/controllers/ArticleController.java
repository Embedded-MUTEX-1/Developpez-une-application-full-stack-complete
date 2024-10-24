package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.ArticleDTO;
import com.openclassrooms.mddapi.dto.HttpMessageDTO;
import com.openclassrooms.mddapi.dto.PostArticleDTO;
import com.openclassrooms.mddapi.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(final ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public List<ArticleDTO> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable final Long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping("")
    public HttpMessageDTO createArticle(@RequestBody final PostArticleDTO articleDTO) {
        articleService.addArticle(articleDTO);
        return new HttpMessageDTO("Article created");
    }
}
