package com.openclassrooms.mddapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentDTO {
    private Long userId; // TODO use security context

    private String comment;
}
