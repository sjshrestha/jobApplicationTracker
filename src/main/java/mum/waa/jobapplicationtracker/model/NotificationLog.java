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
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author lokex
 */
@Entity
@Table(name="notification_log")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
//    @ManyToOne
//    @JoinColumn(name="job_opening_id")
//    private JobOpening jobOpening;
    
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "send_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private String sendDate;
    
    private boolean isRead;
    
    private String bodyText;

    public NotificationLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public JobOpening getJobOpening() {
//        return jobOpening;
//    }
//
//    public void setJobOpening(JobOpening jobOpening) {
//        this.jobOpening = jobOpening;
//    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
    
    
    
}
