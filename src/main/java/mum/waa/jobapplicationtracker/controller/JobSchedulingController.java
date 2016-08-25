/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mum.waa.jobapplicationtracker.model.JobEvent;
import mum.waa.jobapplicationtracker.model.JobOpening;
import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.service.IJobEventService;
import mum.waa.jobapplicationtracker.service.IJobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author suraj
 */
@Controller
public class JobSchedulingController {

    @Autowired
    private IJobEventService jobEventService;
    
    @Autowired
    private IJobOpeningService jobOpeningService;
    
    
    @RequestMapping(value="/jobscheduling", method=RequestMethod.GET)
    public String loadJobScheduling(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<JobEvent> jobList = jobEventService.getAllJobEvents(user.getId());
        model.addAttribute("allJobs", jobList);
        return "jobscheduling";
    }

    @RequestMapping(value = "/newjobschedule", method = RequestMethod.GET)
    public String newJobScheduleForm(Model model, HttpServletRequest request) {
        JobEvent jobEvent = new JobEvent();
        User u = (User)request.getSession().getAttribute("user");
        List<JobOpening> jobList = jobOpeningService.getAllJobOpenings(u.getId());
        
//        List<String> jobList = new ArrayList<>();
//        jobList.add("dot net");
//        jobList.add("java");
//        jobList.add("php");
        model.addAttribute("newJobSchedule", jobEvent);
        model.addAttribute("jobList", jobList);
        return "newjobschedule";
    }

    @RequestMapping(value = "/newjobschedule", method = RequestMethod.POST)
    public String addJobSchedule(@ModelAttribute("newJobSchedule") JobEvent jobEvent, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        long userId = user.getId();
        long str = Long.parseLong(jobEvent.getSelectedJobCategory());
        
        jobEventService.addJobEvent(userId, str, jobEvent);
        return "redirect:/jobscheduling";
    }
}
