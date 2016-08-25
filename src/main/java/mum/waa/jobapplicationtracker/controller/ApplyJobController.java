/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mum.waa.jobapplicationtracker.model.JobLog;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.service.IJobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author suraj
 */
@Controller
public class ApplyJobController {

    class PaginationData<T> {

        public List<T> data = new ArrayList<>();
        public int totalCount;

        public PaginationData(List<T> list, int count) {
            this.data = list;
            this.totalCount = count;
        }
    }

    @Autowired
    private IJobOpeningService jobOpeningService;

    @Autowired
    private IJobOpeningService jobService;

    @RequestMapping("/applyjob")
    public String loadDashboard() {
        return "applyjob";
    }

    @RequestMapping(value = "/applyjoblist", method = RequestMethod.GET)
    public String loadAppliedJobListPage() {
        return "appliedjobsearch";
    }

    @RequestMapping(value = "/getappliedjoblist/{itemsPerPage}/{pageno}", method = RequestMethod.GET)
    public @ResponseBody
    PaginationData<JobOpening> getAppliedJobList(String filter, @PathVariable int itemsPerPage, @PathVariable int pageno, HttpServletRequest request) {
        List<JobOpening> jobs = new ArrayList<>();

        User user = (User) request.getSession().getAttribute("user");
        jobs = jobService.getAllJobOpenings(user.getId());

        List<JobOpening> temp = new ArrayList<>();
        for (JobOpening jobOpening : jobs) {
            JobOpening j = new JobOpening();
            j.setJobTitle(jobOpening.getJobTitle());
            j.setCompanyName(jobOpening.getCompanyName());
            j.setJobDescription(jobOpening.getJobDescription());
            j.setContactNumber(jobOpening.getContactNumber());
            j.setContactPerson(jobOpening.getContactPerson());
            j.setEndDate(jobOpening.getEndDate());
            j.setId(jobOpening.getId());
            temp.add(j);
        }

        if (filter != null) {
            temp = temp.stream()
                    .filter(job -> job.getJobTitle().toUpperCase().contains(filter.toUpperCase()))
                    .collect(Collectors.toList());
        };
        
        int totalRecords = temp.size();

        temp = temp.stream()
                .skip((itemsPerPage * (pageno - 1)))
                .limit(itemsPerPage)
                .collect(Collectors.toList());

        return new PaginationData<JobOpening>(temp, totalRecords);
    }

    @RequestMapping(value = "/applyjob/addjob", method = RequestMethod.GET)
    public String getNewJobFrom() {
        return "newjob";
    }

    @RequestMapping(value = "/applyjob/addjob", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addJobRest(@RequestBody @Valid JobOpening job, BindingResult result, HttpServletRequest request) {
        //long userId = (long) request.getSession().getAttribute("userId");
        User u = (User) request.getSession().getAttribute("user");
        long userId = u.getId();
        if (!result.hasErrors()) {

            jobService.addJobOpening(userId, job);
        }

    }

    @RequestMapping(value = "/applyjob/addlog", method = RequestMethod.GET)
    public String getAddLogPage(@RequestParam("jobId") String jobId, Model model) {

        JobLog jobLog = new JobLog();
        jobLog.setJobOpening(jobOpeningService.getById(Long.valueOf(jobId)));
        model.addAttribute("jobLog", jobLog);
        return "addJobLog";
    }

    @RequestMapping(value = "/applyjob/addlog", method = RequestMethod.POST)
    public String addJobLog(JobLog jobLog, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        jobOpeningService.addJobLog(user.getId(), jobLog);
        return "redirect:/applyjob";
    }

    @RequestMapping(value = "/applyjob/viewJobDetails", method = RequestMethod.GET)
    public String getJobOpeningDetailPage(@RequestParam("jobId") String jobId, Model model) {

//            JobOpening job = new JobOpening();
//            job.setId((long)01);
//            job.setJobTitle("Job title");
//            job.setContactPerson("Contact person");
//            job.setContactNumber("6414512121");
//            job.setJobDescription("Description");
//            job.setCompanyName("Company name");
//            job.setEndDate("2017-12-10");
//          model.addAttribute("job", job);  
        model.addAttribute("job", jobOpeningService.getById(Long.valueOf(jobId)));
        return "appliedJobDetails";
    }

}
