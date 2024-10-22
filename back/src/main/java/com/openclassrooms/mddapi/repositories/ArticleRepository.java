package com.openclassrooms.mddapi.repositories;

import com.openclassrooms.mddapi.models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
