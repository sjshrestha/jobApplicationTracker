/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance.impl;

import java.util.List;
import mum.waa.jobapplicationtracker.model.JobEvent;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.persistance.AbstractDao;
import mum.waa.jobapplicationtracker.persistance.IJobEventDao;
import mum.waa.jobapplicationtracker.service.IJobEventService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lokex
 */
@Repository
public class JobEventDao extends AbstractDao<Long, JobEvent> implements IJobEventDao{

    @Override
    public List<JobEvent> getAllJobEvents(User user) {
         Criteria criteria = createEntityCriteria();
         criteria.add(Restrictions.eq("user", user));
         return (List<JobEvent>) criteria.list();
    }

    @Override
    public List<JobEvent> getJobEventsByJob(User user, JobOpening jobOpening) {
         Criteria criteria = createEntityCriteria();
         criteria.add(Restrictions.eq("user", user));
         criteria.add(Restrictions.eq("jobOpening", jobOpening));
         return (List<JobEvent>) criteria.list();

    }

    @Override
    public JobEvent getById(long id) {
         Criteria criteria = createEntityCriteria();
         criteria.add(Restrictions.eq("id", id));
         return (JobEvent) criteria.uniqueResult();
    }

    @Override
    public void addJobEvent(JobEvent jobEvent) {
        persist(jobEvent);
    }
    
}
