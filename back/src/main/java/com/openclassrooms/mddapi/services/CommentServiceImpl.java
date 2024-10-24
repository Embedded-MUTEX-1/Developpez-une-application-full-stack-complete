package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentDTO;
import com.openclassrooms.mddapi.dto.PostCommentDTO;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;

    @Autowired
    CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addComment(PostCommentDTO commentDTO) {
        Comment comment = new Comment();
        User user = userRepository.findById(commentDTO.getUserId()).orElseThrow(); // TODO Get with security context

        comment.setComment(commentDTO.getComment());
        comment.setUser(user);

        commentRepository.save(comment);
    }
}
