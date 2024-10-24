package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.PostCommentDTO;

public interface CommentService {
    public void addComment(PostCommentDTO commentDTO);
}
