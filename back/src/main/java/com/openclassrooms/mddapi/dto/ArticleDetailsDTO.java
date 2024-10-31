package com.openclassrooms.mddapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailsDTO {
    private Long id;

    private String title;

    private String content;

    private Date createdAt;

    private String author;

    private String theme;

    private List<CommentDTO> comments;
}
