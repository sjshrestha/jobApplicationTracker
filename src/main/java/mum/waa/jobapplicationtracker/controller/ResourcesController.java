/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mum.waa.jobapplicationtracker.model.FileUpload;
import mum.waa.jobapplicationtracker.model.MultiFileUpload;
import mum.waa.jobapplicationtracker.validator.FileValidator;
import mum.waa.jobapplicationtracker.validator.MultiFileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author suraj
 */
@Controller
public class ResourcesController {

    @RequestMapping("/userfaq")
    public String loadUserFaq() {
        return "userfaq";
    }

    @Autowired
    private FileValidator fileValidator;

    @Autowired
    private MultiFileValidator multiFileValidator;

    @InitBinder("fileBucket")
    protected void initBinderFileBucket(WebDataBinder binder) {
        binder.addValidators(fileValidator);
    }

    @InitBinder("multiFileBucket")
    protected void initBinderMultiFileBucket(WebDataBinder binder) {
        binder.addValidators(multiFileValidator);
    }

    @RequestMapping(value = {"/filesupload"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {

        return "filesupload";
    }

    @RequestMapping(value = "/singleUpload", method = RequestMethod.GET)
    public String getSingleUploadPage(Model model) {
        FileUpload fileModel = new FileUpload();
        model.addAttribute("fileBucket", fileModel);
        return "singleFileUploader";
    }

    @RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
    public String singleFileUpload(@ModelAttribute("fileBucket") @Valid FileUpload fileBucket,
            BindingResult result, Model model, HttpServletRequest request) throws IOException {

        MultipartFile multipartFile = fileBucket.getFile();
        if (!result.hasErrors()) {
            if (multipartFile != null && !multipartFile.isEmpty()) {
                try {
                    String fileName = multipartFile.getOriginalFilename();
                    multipartFile.transferTo(new File("\\tmp\\" + fileName));
                    model.addAttribute("fileName", fileName);
                    return "success";
                } catch (Exception e) {
                    throw new RuntimeException("File upload exception occurred", e);
                }
            }
        }
        return "singleFileUploader";
    }

    @RequestMapping(value = "/multiUpload", method = RequestMethod.GET)
    public String getMultiUploadPage(ModelMap model) {
        MultiFileUpload filesModel = new MultiFileUpload();
        model.addAttribute("multiFileBucket", filesModel);
        return "multiFileUploader";
    }

    @RequestMapping(value = "/multiUpload", method = RequestMethod.POST)
    public String multiFileUpload(@ModelAttribute("multiFileBucket") @Valid MultiFileUpload multiFileBucket,
            BindingResult result, ModelMap model) throws IOException {

        if (result.hasErrors()) {
            System.out.println("validation errors in multi upload");
            return "multiFileUploader";
        } else {
            System.out.println("Fetching files");
            List<String> fileNames = new ArrayList<String>();
            for (FileUpload bucket : multiFileBucket.getFiles()) {
                FileCopyUtils.copy(bucket.getFile().getBytes(), new File("\\tmp\\" + bucket.getFile().getOriginalFilename()));
                fileNames.add(bucket.getFile().getOriginalFilename());

            }
            List<String> fileList = new ArrayList<>();
            fileList = listFiles("c:\\tmp\\");
            model.addAttribute("fileNames", fileNames);
            
            model.addAttribute("fileList", fileList);
            return "userfaq";
        }
    }

    public List<String> listFiles(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        List<String> fileList = new ArrayList<>();
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getName());
                fileList.add(file.getName());
            }
        }
        return fileList;
    }

}
