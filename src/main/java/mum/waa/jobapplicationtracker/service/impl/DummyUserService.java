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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author lokex
 */
@Service
@Transactional
public class DummyUserService {

    @Autowired private IuserDao userDao;
    
//    @Autowired
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        
        
        this.transactionTemplate = transactionTemplate;
    }
    
    
    
    public long addNewUser(final User user) {
        

        User dummyUser = new User("usertest", "test");
        dummyUser.setUsername("dummyUser");
        dummyUser.setFirstName("testFname");
        dummyUser.setLastName("testLname");
        dummyUser.setPassword("mypassword");
        dummyUser.setEmail("abc@test.com");
        dummyUser.setPhone("9723293223");
                
       userDao.saveUser(dummyUser);
       return dummyUser.getId();
        
    }

    public boolean authenticate(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
