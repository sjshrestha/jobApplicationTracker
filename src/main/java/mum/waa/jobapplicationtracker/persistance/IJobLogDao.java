/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobLog;
import mum.waa.jobapplicationtracker.model.JobOpening;

/**
 *
 * @author lokex
 */
public interface IJobLogDao {
    
    void addJobLog(JobLog jobLog);
    List<JobLog> getJobLogs(JobOpening jobOpening);
    
    
}
