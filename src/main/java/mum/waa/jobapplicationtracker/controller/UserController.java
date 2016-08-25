/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.service.IuserService;
import mum.waa.jobapplicationtracker.validator.PasswordValidator;
import mum.waa.jobapplicationtracker.validator.UserExistsValidator;
import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dilip
 */
@Controller
public class UserController {
    
    class Message{
        public String message;
        public Message(String msg){
            this.message = msg;
        }
    }
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private IuserService userService;

    @Autowired
    private UserExistsValidator userExistsValidator;
    
    @InitBinder("user")
    protected void initBinderFileBucket(WebDataBinder binder) {
        binder.addValidators(userExistsValidator);
    }

    @RequestMapping("/")
    public String loadWelcomePage() {
        return "redirect:/login";
        //return "login_newuser";
    }

    @RequestMapping("/login")
    public String getLoginPage(Model model) {
//        model.addAttribute("newUser", new User());
        return "login_newuser";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String doLogin(User user, HttpServletRequest request, Model model) {
        if (userService.authenticate(user)) {
            request.getSession().setAttribute("user", user);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error","Invalid Username or Password");
            return "login_newuser";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Message registerUser(@RequestBody @Valid User user, BindingResult result, HttpServletRequest request) {
        String status = "ok";
        if (!result.hasErrors()) {
            long userId = userService.addNewUser(user);
            request.getSession().setAttribute("user", user);
        }
        
        else{
            status = "User already exists.";
            System.out.println("user.username.already.exists");
        }
        return new Message(status);
    }

    @RequestMapping(value = "/pagination", method = RequestMethod.GET)
    public String loadPaginationPage() {
        return "pagination";
    }

    @RequestMapping("/changepassword")
    public String loadChangePassword() {
        return "changepassword";
    }

    @RequestMapping("/settings")
    public String loadSettings() {
        return "settings";
    }

    @RequestMapping("/logout")
    public String loadLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        
        return "redirect:/login";
    }
}
