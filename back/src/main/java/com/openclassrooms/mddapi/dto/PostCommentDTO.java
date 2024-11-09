package com.openclassrooms.mddapi.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentDTO {
    @NotNull
    private Long userId;
    @NotNull
    private Long articleId;
    @Size(min = 1, max = 255)
    private String comment;
}
