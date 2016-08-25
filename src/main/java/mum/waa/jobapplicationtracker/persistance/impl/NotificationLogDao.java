/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance.impl;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.model.NotificationLog;
import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.persistance.AbstractDao;
import mum.waa.jobapplicationtracker.persistance.INotificationLogDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lokex
 */
@Repository
public class NotificationLogDao extends AbstractDao<Long, NotificationLog> implements INotificationLogDao{

    @Override
    public void addNotification(NotificationLog notification) {
            persist(notification);
    }

    @Override
    public List<NotificationLog> getAllNotifications(User user) {
        Criteria criteria = createEntityCriteria();
         criteria.add(Restrictions.eq("user", user));
         return (List<NotificationLog>) criteria.list();
    }

    @Override
    public List<NotificationLog> getUnreadNotifications(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("isRead", false));
        
        return (List<NotificationLog>) criteria.list();
    }

    @Override
    public NotificationLog getById(long notificationId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", notificationId));
        return (NotificationLog) criteria.uniqueResult();
    }

   
    @Override
    public void updateNotificationAsRead(long notificationId, boolean isRead) {
        
        Query query = getSession().createSQLQuery("update notification_log set isRead=:isRead where id=:ID");
        query.setString("isRead", String.valueOf(isRead));
        query.setString("ID", String.valueOf(notificationId));
        query.executeUpdate();
        
    }
    
}
