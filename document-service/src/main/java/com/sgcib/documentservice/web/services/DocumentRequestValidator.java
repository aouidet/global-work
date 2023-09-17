package com.sgcib.documentservice.web.services;

import com.sgcib.documentservice.infrastructure.exception.ErrorCodeEnum;
import com.sgcib.documentservice.web.AppCodeEnum;
import com.sgcib.documentservice.web.model.DocumentRequest;
import com.sgcib.documentservice.web.validator.AllNetDocumentRequestValidator;
import com.sgcib.documentservice.web.validator.IDocumentRequestValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

@Component
public class DocumentRequestValidator {

    private final Map<AppCodeEnum, IDocumentRequestValidator> appRequestValidator =
            Map.ofEntries(
                    entry(AppCodeEnum.ALLNET, new AllNetDocumentRequestValidator())
                    //entry(AppCodeEnum.DTR, new DigitradeDocumentRequestValidator()),
                    //entry(AppCodeEnum.PETRA, new PetraDocumentRequestValidator())
            );

    private String createErrorString(Errors errors) {
        return errors.getAllErrors().stream().map(
                ObjectError::getDefaultMessage
        ).collect(Collectors.joining(","));
    }


    public void validate(String appCode, DocumentRequest documentRequest, Errors errors) {
        if(appRequestValidator.containsKey(AppCodeEnum.valueOf(appCode))) {
            appRequestValidator.get(AppCodeEnum.valueOf(appCode))
                    .validate(documentRequest, errors);
            if(errors.hasErrors()) {
                throw new IllegalArgumentException(
                        String.format(ErrorCodeEnum.DM_400_000002.name(), appCode),
                        createErrorString(errors);
                );
            }
        }
    }
}
