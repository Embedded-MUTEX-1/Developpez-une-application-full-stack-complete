package com.openclassrooms.mddapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewArticleDTO {
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private Long themeId;
}
