/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author lokex
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "username", nullable = false)
    private String username;
    
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "password", nullable = false)
    private String password;
    
    @Transient
    private String repassword;
    
    @Size(min = 3, max = 50)
    @Column(name = "firstname")
    private String firstName;
    
    @Size(min = 3, max = 50)
    @Column(name = "lastname")
    private String lastName;
    
    @Size(min = 3, max = 50)
    @Column(name = "email")
    private String email;
    
    @Size(min = 3, max = 50)
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "forget_token")
    private String forgetToken;
    
    @Column(name="is_active")
    private boolean isActive;
    
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="created_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private String createdDate;
    
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "last_login_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private String lastLogin;
    
    @Column(name="api_token")
    private String apiToken;
    
    
    @OneToMany(mappedBy = "user")//should be the instance variable name in JobOpening class
    private List<JobOpening> appliedJobs = new ArrayList<>();
    
    @OneToMany(mappedBy = "user")
    private List<JobLog> jobLogs = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(mappedBy = "user")
    private List<Resource> resources = new ArrayList<Resource>();
    
    @OneToMany(mappedBy="user")
    private List<NotificationLog> notificationLogs = new ArrayList<>();
    
    
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getForgetToken() {
        return forgetToken;
    }

    public void setForgetToken(String forgetToken) {
        this.forgetToken = forgetToken;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public List<JobOpening> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<JobOpening> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<JobLog> getJobLogs() {
        return jobLogs;
    }

    public void setJobLogs(List<JobLog> jobLogs) {
        this.jobLogs = jobLogs;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<NotificationLog> getNotificationLogs() {
        return notificationLogs;
    }

    public void setNotificationLogs(List<NotificationLog> notificationLogs) {
        this.notificationLogs = notificationLogs;
    }

    
    
    
}
