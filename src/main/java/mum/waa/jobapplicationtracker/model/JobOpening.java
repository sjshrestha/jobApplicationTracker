/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author lokex
 */
@Entity
@Table(name = "job_openings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String jobTitle;
    
    private String companyName;
    
    private String companyAddress;
    
    private String positionTitle;
    
    private String jobDescription;
    
    @Column(name = "applied_date")
    private String appliedDate;
    
    @ElementCollection
    @CollectionTable(name="req_technologies",joinColumns = @JoinColumn(name="id"))
    @Column(name="required_technologies")
    private List<String> requiredTechnologies;
    
    
    private int statusId;
    
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "end_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private String endDate;
    
    private String contactPerson;
    
    private String contactNumber;
    
    @OneToMany(mappedBy = "jobOpening", fetch = FetchType.EAGER)
    private List<JobLog> logs= new ArrayList<>();
    
    @ManyToOne 
    @JoinColumn(name = "user_id")// creates a column in JobOpening table with a foreign key "user_id" referencing to userId
    private User user;
    

    public JobOpening() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public List<String> getRequiredTechnologies() {
        return requiredTechnologies;
    }

    public void setRequiredTechnologies(List<String> requiredTechnologies) {
        this.requiredTechnologies = requiredTechnologies;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<JobLog> getLogs() {
        return logs;
    }

    public void setLogs(List<JobLog> logs) {
        this.logs = logs;
    }

    
}
