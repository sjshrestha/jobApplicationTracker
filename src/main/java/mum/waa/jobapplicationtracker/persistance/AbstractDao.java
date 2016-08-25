/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rakesh Shrestha
 */
public abstract class AbstractDao<PK extends Serializable, T>{
    private final Class<T> persistentClass;
    @Autowired
    private SessionFactory sessionFactory;
    
    public AbstractDao() {
        // Will be Employee class in our case
        // this here referst to EmployeeDaoImpl whcih is a concrete class
        // genricSuperClass of EmplyeeDaoImpl is AbsractDAO<Integer, Employee>
        // typer argument [1] in this case is Employee
        this.persistentClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    
   
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public T getByKey(PK key){
        return (T) getSession().get(persistentClass, key);
    }
    
    public void persist(T entity){
        getSession().persist(entity);
    }
    
    public void delete(T entity){
        getSession().delete(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
