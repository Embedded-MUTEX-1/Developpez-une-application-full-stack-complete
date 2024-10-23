package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.Theme;
import com.openclassrooms.mddapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;

    private String title;

    private String content;

    private User user;

    private Theme theme;
}
