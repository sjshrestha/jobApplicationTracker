/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.validator;

import mum.waa.jobapplicationtracker.model.FileUpload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dilip
 */
@Component
public class FileValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return FileUpload.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        FileUpload fileUpload = (FileUpload)obj;
        if(fileUpload.getFile()!=null){
            if (fileUpload.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }

}
