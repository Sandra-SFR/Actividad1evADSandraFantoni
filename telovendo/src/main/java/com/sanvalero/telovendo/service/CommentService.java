package com.sanvalero.telovendo.service;

import com.sanvalero.telovendo.domain.Comment;
import com.sanvalero.telovendo.exception.CommentNotFoundException;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    Comment findById(long id) throws CommentNotFoundException;
    Comment addComment(Comment comment);
    void deleteComment(long id) throws CommentNotFoundException;
    Comment modifyComment(long id, Comment newComment)throws CommentNotFoundException;
}
