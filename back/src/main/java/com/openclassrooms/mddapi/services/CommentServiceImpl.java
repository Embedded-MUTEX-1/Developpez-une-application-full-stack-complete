package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentDTO;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    @Autowired
    CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void addComment(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        commentRepository.save(comment);
    }
}
