package com.etu.grigorova;

/**
 * Exception for my Bowling game realization
 *
 * @author AlGrigorova
 */
public class BowlingGameException extends Exception {
    //Constructor without parameters
    public BowlingGameException() {}
    //Constructor that accepts a message
    public BowlingGameException (String message){
        super(message);
    }
}
