/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service.impl;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobEvent;
import mum.waa.jobapplicationtracker.persistance.IJobEventDao;
import mum.waa.jobapplicationtracker.service.IJobEventService;
import mum.waa.jobapplicationtracker.service.IJobOpeningService;
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
public class JobEventService implements IJobEventService{

    @Autowired private IJobEventDao jobEventDao;
    
    @Autowired private IJobOpeningService jobOpeningService;
    
    @Autowired private IuserService userService;
    
    @Override
    public List<JobEvent> getAllJobEvents(long userId) {
        return jobEventDao.getAllJobEvents(userService.getById(userId));
    }

    @Override
    public List<JobEvent> getJobEventsByJob(long userId, long jobOpeningId) {
        return jobEventDao.getJobEventsByJob(userService.getById(userId), jobOpeningService.getById(jobOpeningId));
    }

    @Override
    public void addJobEvent(long userId, long jobOpeningId, JobEvent jobEvent) {
        jobEvent.setJobOpening(jobOpeningService.getById(jobOpeningId));
        jobEvent.setUser(userService.getById(userId));
        jobEventDao.addJobEvent(jobEvent);
        
    }

    @Override
    public JobEvent getById(long Id) {
        return jobEventDao.getById(Id);
    }
    
    
    
}
