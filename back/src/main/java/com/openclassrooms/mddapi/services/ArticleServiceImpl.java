package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ArticleDTO;
import com.openclassrooms.mddapi.dto.CommentDTO;
import com.openclassrooms.mddapi.dto.PostArticleDTO;
import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.models.Theme;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private ThemeRepository themeRepository;
    private ModelMapper modelMapper;

    @Autowired
    ArticleServiceImpl(UserRepository userRepository, ArticleRepository articleRepository, ThemeRepository themeRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.themeRepository = themeRepository;
        this.modelMapper = new ModelMapper();

        TypeMap<Article, ArticleDTO> typeMapArticle = this.modelMapper.createTypeMap(Article.class, ArticleDTO.class);
        TypeMap<Comment, CommentDTO> typeMapComment = this.modelMapper.createTypeMap(Comment.class, CommentDTO.class);


        typeMapArticle.addMappings(mapper -> mapper.map(src -> src.getUser().getUsername(), ArticleDTO::setAuthor));
        typeMapArticle.addMappings(mapper -> mapper.map(src -> src.getTheme().getName(), ArticleDTO::setTheme));

        typeMapComment.addMappings(mapper -> mapper.map(src -> src.getUser().getUsername(), CommentDTO::setComment));
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<ArticleDTO>>(){}.getType());
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public void addArticle(PostArticleDTO articleDTO) {
        Article article = new Article();

        article.setTitle(articleDTO.getTitle());
        article.setContent(articleDTO.getContent());
        article.setCreatedAt(new Date());

        User user = userRepository.findById(articleDTO.getUserId()).orElseThrow();
        Theme theme = themeRepository.findById(articleDTO.getThemeId()).orElseThrow();

        article.setUser(user);
        article.setTheme(theme);

        articleRepository.save(article);
    }
}
