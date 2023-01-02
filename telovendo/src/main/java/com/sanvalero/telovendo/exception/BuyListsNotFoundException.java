package com.sanvalero.telovendo.exception;

public class BuyListsNotFoundException extends Exception {

    public BuyListsNotFoundException(){
        super("Lista no encontrada");
    }

    public BuyListsNotFoundException(String message){
        super(message);
    }
}
