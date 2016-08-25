/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service;

import mum.waa.jobapplicationtracker.model.User;

/**
 *
 * @author lokex
 */
public interface IuserService {

   boolean validateRetypePassword(User user);
   long addNewUser(User user);
   boolean authenticate(User user);
   
   User getById(long userId);
   
   User getByUsername(String username);
   
   void updateUser(User user);
    
}
