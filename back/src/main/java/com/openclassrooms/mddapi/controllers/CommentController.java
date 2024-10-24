package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.HttpMessageDTO;
import com.openclassrooms.mddapi.dto.PostCommentDTO;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("")
    public HttpMessageDTO addComment(@RequestBody PostCommentDTO comment) {
        commentService.addComment(comment);
        return new HttpMessageDTO("Comment added");
    }
}
