package com.sanvalero.telovendo.exception;

public class BuyListNotFoundException extends Exception {

    public BuyListNotFoundException(){
        super("List not found");
    }

    public BuyListNotFoundException(String message){
        super(message);
    }
}
