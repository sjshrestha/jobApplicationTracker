/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service;

import java.util.List;
import mum.waa.jobapplicationtracker.model.NotificationLog;

/**
 *
 * @author lokex
 */
public interface INotificationService {
     List<NotificationLog> getNotificationLogs(long userId);
     void addNotificationLog(long userId,NotificationLog notificationLog);
     NotificationLog getNotificationById(long notificationId);
     void markNotificationAsRead(long notificationId,boolean isRead);
     List<NotificationLog> getUnreadNotifications(long userId);
}
