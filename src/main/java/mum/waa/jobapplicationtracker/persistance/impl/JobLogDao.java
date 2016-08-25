/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance.impl;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobLog;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.persistance.AbstractDao;
import mum.waa.jobapplicationtracker.persistance.IJobLogDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lokex
 */
@Repository
public class JobLogDao extends AbstractDao<Long, JobLog> implements IJobLogDao{

    @Override
    public void addJobLog(JobLog jobLog) {
        persist(jobLog);
    }

    @Override
    public List<JobLog> getJobLogs(JobOpening jobOpening) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("jobOpening", jobOpening));
        return (List<JobLog>) criteria.list();
    }
    
}
