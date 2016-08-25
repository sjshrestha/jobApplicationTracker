/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mum.waa.jobapplicationtracker.model.JobLog;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.persistance.IJobLogDao;
import mum.waa.jobapplicationtracker.persistance.IJobOpeningDao;
import mum.waa.jobapplicationtracker.service.IJobOpeningService;
import mum.waa.jobapplicationtracker.service.IuserService;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lokex
 */
@Service
@Transactional
public class JobOpeningService implements IJobOpeningService{

    @Autowired
    private IuserService userService;
    
    @Autowired
    private IJobOpeningDao jobOpeningDao;
    
    @Autowired
    private IJobLogDao jobLogDao;
    
    @Override
    public void addJobOpening(long userId, JobOpening jobOpening) {
        
       jobOpening.setUser(userService.getById(userId));
       jobOpeningDao.addJobOpening(jobOpening);
        
    }

    @Override
    public List<JobOpening> getAllJobOpenings(long userId) {
        return jobOpeningDao.getAllJobOpenings(userService.getById(userId));
    }
    
    @Override
    public JobOpening getById(long jobOpeningId) {
        return jobOpeningDao.getById(jobOpeningId);
    }
    
    @Override
    public List<JobLog> getJobLogs(long jobOpeningId) {
        return jobLogDao.getJobLogs(getById(jobOpeningId));
    }


    @Override
    public void addJobLog(long jobOpeningId, JobLog jobLog) {
        
        jobLog.setJobOpening(getById(jobOpeningId));
        
        LocalDate localDate = LocalDate.now();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = sdf.format(date);
        jobLog.setCreatedDate(datestr);
        jobLogDao.addJobLog(jobLog);
    }


    @Override
    public void logJobAppy(long jobOpeningId) {
       jobOpeningDao.logJobAppy(jobOpeningId);
    }

    
    
}
