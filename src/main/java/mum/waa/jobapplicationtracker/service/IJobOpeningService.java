/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobLog;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.model.NotificationLog;

/**
 *
 * @author lokex
 */
public interface IJobOpeningService {
    
    void addJobOpening(long userId,JobOpening jobOpening);
    
    List<JobOpening> getAllJobOpenings(long userId);
    
    JobOpening getById(long jobOpeningId);
    
    List<JobLog> getJobLogs(long jobOpeningId);
    
    void addJobLog(long jobOpeningId,JobLog jobLog);
    
    void logJobAppy(long jobOpeningId);
}
