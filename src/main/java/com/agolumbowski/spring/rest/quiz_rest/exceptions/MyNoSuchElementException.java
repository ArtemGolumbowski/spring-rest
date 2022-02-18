/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.exceptions;

/**
 *
 * @author agolu
 */
public class MyNoSuchElementException extends RuntimeException{

    public MyNoSuchElementException(String message) {
        super(message);
    }
    
}
