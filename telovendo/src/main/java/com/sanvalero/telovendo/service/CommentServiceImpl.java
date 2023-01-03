package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.Comment;
import com.sanvalero.telovendo.exception.CommentNotFoundException;
import com.sanvalero.telovendo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(long id) throws CommentNotFoundException{
        return commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) throws CommentNotFoundException{
        Comment comment = commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
        commentRepository.delete(comment);
    }

    @Override
    public Comment modifyComment(long id, Comment newComment) throws CommentNotFoundException{
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
        existingComment.setCommentText(newComment.getCommentText());
        // Introducir todos los campos que se quieran modificar
        return commentRepository.save(existingComment);
    }
}
