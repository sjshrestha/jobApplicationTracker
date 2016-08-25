/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dilip
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiFileUpload {
    List<FileUpload> files = new ArrayList<FileUpload>();
     
    //three files at a time
    public MultiFileUpload(){
        files.add(new FileUpload());
        files.add(new FileUpload());
        files.add(new FileUpload());
    }
     
    public List<FileUpload> getFiles() {
        return files;
    }
 
    public void setFiles(List<FileUpload> files) {
        this.files = files;
    }
}
