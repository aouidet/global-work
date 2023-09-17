package com.sgcib.documentservice.web.validator;

import com.sgcib.documentservice.web.model.DocumentRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;

public class AllNetDocumentRequestValidator implements IDocumentRequestValidator {
    @Override
    public void validate(DocumentRequest request, Errors errors) {
        if(StringUtils.isNotEmpty(request.getDealNumber())) {
            errors.reject("dealNumber", "deal number must be not empty");
        }

        if(StringUtils.isNotEmpty(request.getRefMtp())) {
            errors.reject("refMtp", "ref mtp number must be not empty");
        }
    }
}
