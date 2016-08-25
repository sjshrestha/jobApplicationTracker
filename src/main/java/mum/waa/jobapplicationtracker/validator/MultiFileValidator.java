/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.validator;

import mum.waa.jobapplicationtracker.model.FileUpload;
import mum.waa.jobapplicationtracker.model.MultiFileUpload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dilip
 */
@Component
public class MultiFileValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return MultiFileUpload.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        MultiFileUpload multiFile = (MultiFileUpload)obj;
        int index=0;
         
        for(FileUpload file : multiFile.getFiles()){
            if(file.getFile()!=null){
                if (file.getFile().getSize() == 0) {
                    errors.rejectValue("files["+index+"].file", "missing.file");
                }
            }
            index++;
        }
    }
    
}
