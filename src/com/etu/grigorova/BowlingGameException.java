package com.etu.grigorova;

/**
 * Created by zikovam on 29.11.16.
 */
public class BowlingGameException extends Exception {
    //Constructor without parameters
    public BowlingGameException() {}
    //Constructor that accepts a message
    public BowlingGameException (String message){
        super(message);
    }
}
