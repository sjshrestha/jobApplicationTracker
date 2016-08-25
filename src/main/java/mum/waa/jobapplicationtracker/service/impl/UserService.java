/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service.impl;

import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.persistance.IuserDao;
import mum.waa.jobapplicationtracker.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lokex
 */
@Service
@Transactional
public class UserService implements IuserService{

    @Autowired private IuserDao userDao;
    
    
    @Override
    public long addNewUser(final User user) {
        
       userDao.saveUser(user);
       return user.getId();
    }

    @Override
    public boolean authenticate(User user) {
        
        User matchedUser = userDao.getByUserName(user.getUsername());
       if(matchedUser!=null){
       
           if(matchedUser.getPassword().equals(user.getPassword())){
               user.setId(matchedUser.getId());
               user.setEmail(matchedUser.getEmail());
               user.setFirstName(matchedUser.getFirstName());
               user.setLastName(matchedUser.getLastName());
               user.setRole(matchedUser.getRole());
               user.setPhone(matchedUser.getPhone());
               user.setCreatedDate(matchedUser.getCreatedDate());
               
               return true;
           }
            
       }
       
       return false;
    }

    @Override
    public User getById(long userId) {
        return userDao.getUser(userId);
    }
    
    @Override
    public User getByUsername(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public boolean validateRetypePassword(User user) {
        return user.getPassword().equals(user.getRepassword());
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    
}
