package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ArticleDTO;
import com.openclassrooms.mddapi.dto.PostArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> getAllArticles();
    ArticleDTO getArticleById(Long id);
    void addArticle(PostArticleDTO article);
}
