/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agolu
 */
@RestController
public class MainController {
    
    
   @RequestMapping("/")
    public String home(){
        
        return "redirect:/quizes";
    }
    
   
    
}
