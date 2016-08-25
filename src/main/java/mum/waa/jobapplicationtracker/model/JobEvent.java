/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author lokex
 */
@Entity
@Table(name="job_events")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="job_opening_id")
    private JobOpening jobOpening;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "event_date", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate eventDate; //a
    
    @Column(name="remind_me")
    private boolean remindMe; //a
    
    @Column(name="remind_me_before")
    private int remindDayBefore; //a
    
    @Column(name="remind_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private String remindDate;
    
    private String comment; //a

    private String selectedJobCategory;
    
    public JobEvent() {
    }

    public Long getId() {
        return id;
    }

    public String getSelectedJobCategory() {
        return selectedJobCategory;
    }

    public void setSelectedJobCategory(String selectedJobCategory) {
        this.selectedJobCategory = selectedJobCategory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobOpening getJobOpening() {
        return jobOpening;
    }

    public void setJobOpening(JobOpening jobOpening) {
        this.jobOpening = jobOpening;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isRemindMe() {
        return remindMe;
    }

    public void setRemindMe(boolean remindMe) {
        this.remindMe = remindMe;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRemindDayBefore() {
        return remindDayBefore;
    }

    public void setRemindDayBefore(int remindDayBefore) {
        this.remindDayBefore = remindDayBefore;
    }

    public String getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }
    
    
    
    
}
