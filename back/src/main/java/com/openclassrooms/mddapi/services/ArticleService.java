package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ArticleDTO;
import com.openclassrooms.mddapi.dto.ArticleDetailsDTO;
import com.openclassrooms.mddapi.dto.PostArticleDTO;

import java.util.List;

/**
 * Interface de gestion des articles
 */
public interface ArticleService {
    /**
     * <p>Permet d'obtenir tous les articles postés</p>
     * @return La liste d'articles par ordre de publication
     */
    List<ArticleDTO> getAllArticles();
    /**
     * <p>Permet d'obtenir un article par son Id </p>
     * @param id Identifiant de l'article
     * @return un article par son Id
     */
    ArticleDetailsDTO getArticleById(Long id);
    /**
     * <p>Permet de poster un article </p>
     * @param article Objet contenant les données de l'article
     */
    void addArticle(PostArticleDTO article);
}
