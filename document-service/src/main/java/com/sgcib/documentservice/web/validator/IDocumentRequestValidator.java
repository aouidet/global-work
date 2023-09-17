package com.sgcib.documentservice.web.validator;

import com.sgcib.documentservice.web.model.DocumentRequest;
import org.springframework.validation.Errors;

public interface IDocumentRequestValidator {

    void validate(DocumentRequest request, Errors errors);
}
