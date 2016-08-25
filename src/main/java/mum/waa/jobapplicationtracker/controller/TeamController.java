/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author suraj
 */
@Controller
public class TeamController {
    
    @RequestMapping("/aboutus")
    public String loadAboutUs(){        
        return "team";
    }
    
    
    @RequestMapping("/help")
    public String loadHelp(){        
        return "team";
    }
    
    @RequestMapping("/tutorials")
    public String loadTutorials(){        
        return "team";
    }
   
}
