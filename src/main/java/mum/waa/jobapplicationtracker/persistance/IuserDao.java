/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance;

import mum.waa.jobapplicationtracker.model.User;

/**
 *
 * @author lokex
 */
public interface IuserDao {
    void saveUser(User user);
    User getUser(long userId);
    User getByUserName(String username);

    void updateUser(User user);
}
