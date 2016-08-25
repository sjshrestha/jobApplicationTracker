/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance.impl;

import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.persistance.AbstractDao;
import mum.waa.jobapplicationtracker.persistance.IuserDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lokex
 */
@Repository
public class UserDao extends AbstractDao<Integer, User> implements IuserDao{

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public User getUser(long userId) {
//      Query query = getSession().createSQLQuery("select * from users where id=:userId");
//        query.setString("userId", String.valueOf(userId));
//        query.executeUpdate();
        return getByCriteria("id", userId);
    }

    @Override
    public User getByUserName(String username) {
        return getByCriteria("username", username);
    }
    
    
    public User getByCriteria(String columnName,Object criteriaValue){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq(columnName, criteriaValue));
        return (User) criteria.uniqueResult();
    }

    @Override
    public void updateUser(User user) {
        
        Query query = getSession().createSQLQuery("update users set firstname=:firstName,lastName=:lastName, email=:email, phone=:phone where id=:ID");
        query.setString("fistName", user.getFirstName());
        query.setString("lastName", user.getLastName());
        query.setString("email", user.getEmail());
        query.setString("phone", user.getPhone());
        query.setString("ID", String.valueOf(user.getId()));
        query.executeUpdate();
        
    }
    
}
