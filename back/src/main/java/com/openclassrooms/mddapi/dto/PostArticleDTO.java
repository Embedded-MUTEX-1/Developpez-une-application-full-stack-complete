package com.openclassrooms.mddapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostArticleDTO {
    @NotNull
    private Long userId;
    @Size(min = 6, max = 30)
    private String title;
    @Size(min = 20, max = 1024)
    private String content;
    @NotNull
    private Long themeId;
}
