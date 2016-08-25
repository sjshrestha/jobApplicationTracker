/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobEvent;

/**
 *
 * @author lokex
 */
public interface IJobEventService {
    
    List<JobEvent> getAllJobEvents(long userId);
    
    List<JobEvent> getJobEventsByJob(long userId,long jobOpeningId);
    
    void addJobEvent(long userId,long jobOpeningId,JobEvent jobEvent);
    
    JobEvent getById(long Id);
}
