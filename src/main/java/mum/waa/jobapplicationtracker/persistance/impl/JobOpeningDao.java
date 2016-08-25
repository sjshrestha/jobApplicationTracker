/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.persistance.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.persistance.AbstractDao;
import mum.waa.jobapplicationtracker.persistance.IJobOpeningDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lokex
 */
@Repository
public class JobOpeningDao extends AbstractDao<Long, JobOpening> implements IJobOpeningDao {

    @Override
    public void addJobOpening(JobOpening jobOpening) {
        persist(jobOpening);
    }

    @Override
    public List<JobOpening> getAllJobOpenings(User user) {
        
          Criteria criteria = createEntityCriteria();
          criteria.add(Restrictions.eq("user", user));
        return (List<JobOpening>) criteria.list();
        
    }

    @Override
    public void logJobAppy(long jobOpeningId) {

        LocalDate now = LocalDate.now();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String appliedDate = df.format(now);

        Query query = getSession().createSQLQuery("update job_openings set applied_date=:date where id=:ID");
        query.setString("date", appliedDate);
        query.setString("ID", String.valueOf(jobOpeningId));
        query.executeUpdate();

    }

    @Override
    public JobOpening getById(long jobOpeningId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", jobOpeningId));
        return (JobOpening) criteria.uniqueResult();
    }

}
