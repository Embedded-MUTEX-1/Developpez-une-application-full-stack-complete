package com.openclassrooms.mddapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostArticleDTO {
    private Long userId; // TODO use security context

    private String title;

    private String content;

    private Long themeId;
}
