/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service.impl;

import java.util.List;
import mum.waa.jobapplicationtracker.model.NotificationLog;
import mum.waa.jobapplicationtracker.persistance.INotificationLogDao;
import mum.waa.jobapplicationtracker.service.INotificationService;
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
public class NotificationService implements INotificationService{

    @Autowired private INotificationLogDao notificationLogDao;
    @Autowired private IuserService userService;
    
    @Override
    public List<NotificationLog> getNotificationLogs(long userId) {
        return notificationLogDao.getAllNotifications(userService.getById(userId));
    }

    @Override
    public void addNotificationLog(long userId, NotificationLog notificationLog) {
       notificationLog.setUser(userService.getById(userId));
       notificationLog.setIsRead(false);
       notificationLogDao.addNotification(notificationLog);
    }

    @Override
    public NotificationLog getNotificationById(long notificationId) {
        return notificationLogDao.getById(notificationId);
    }

    @Override
    public void markNotificationAsRead(long notificationId,boolean isRead) {
        notificationLogDao.updateNotificationAsRead(notificationId,isRead);
    }

    @Override
    public List<NotificationLog> getUnreadNotifications(long userId) {
        return notificationLogDao.getUnreadNotifications(userService.getById(userId));
        
    }
    
}
