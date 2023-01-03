package com.sanvalero.telovendo.controller;

import com.sanvalero.telovendo.domain.Comment;
import com.sanvalero.telovendo.exception.BuyListNotFoundException;
import com.sanvalero.telovendo.exception.CommentNotFoundException;
import com.sanvalero.telovendo.exception.ErrorMessage;
import com.sanvalero.telovendo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/telovendo/comment")
    public ResponseEntity<List<Comment>> getTelovendo() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/telovendo/comment/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable long id) throws CommentNotFoundException{
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/telovendo/comment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        Comment newComment = commentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComment);
    }

    @DeleteMapping("/telovendo/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id) throws CommentNotFoundException{
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/telovendo/comment/{id}")
    public ResponseEntity<Comment> modifyComment(@PathVariable long id, @RequestBody Comment comment) throws CommentNotFoundException{
        Comment modifiedComment = commentService.modifyComment(id, comment);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedComment);
    }

    @ExceptionHandler(CommentNotFoundException.class) // para lanzar errores not found
    public ResponseEntity<ErrorMessage> commentNotFoundException(CommentNotFoundException cnfe){
        ErrorMessage errorMessage = new ErrorMessage(404, cnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
