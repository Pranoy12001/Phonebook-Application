package com.pranoy.phonebook.exception;

/**
 *
 * @author Pranoy
 */
public class UserBlockedException extends Exception{
    /**
     * Create User object without error description
     */
    public UserBlockedException() {
    }
    
    /**
     * Create User object with error description
     * @param errDesc 
     */
    public UserBlockedException(String errDesc) {
    }
}
