/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lokex
 */
@Controller
public class JobOpeningController {
    
    
    @RequestMapping(value="/jobopening",method=RequestMethod.GET)
     
    public String getJobOpeningPage(){
    
        return "jobopening";
    }
    
}
