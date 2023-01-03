package com.sanvalero.telovendo.exception;

public class CommentNotFoundException extends Exception{
    public CommentNotFoundException(){
        super("Comment not found");
    }

    public CommentNotFoundException(String message){
        super(message);
    }
}
