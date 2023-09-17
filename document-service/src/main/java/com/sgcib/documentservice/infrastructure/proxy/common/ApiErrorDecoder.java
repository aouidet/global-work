package com.sgcib.documentservice.infrastructure.proxy.common;

import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.nio.charset.Charset;

@ComponentScan
public class ApiErrorDecoder {

    public static final String FGAD_API_ERROR = "FgadApiError";
    public static final String CICS_API_ERROR = "CicsApiError";
    public static final String API_ERROR = "ApiError";
    public static final String FGAD_API_PATTERN = "fgad/api";
    public static final String CICS_API_PATTERN = "cics/api";

    public Exception decode(String s, feign.Response response) {
        return switch (response.status()) {
            case 400 -> new Exception();
            // TOTO replace with module exception basRequest exception
            case 404 -> new Exception(); // NotFoundException
            default -> new Exception(); // GeneralException
        };
    }

    private String getMessage(feign.Response response) {
        try {
            return org.apache.commons.io.IOUtils.toString(response.body().asReader(Charset.defaultCharset()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return response.reason();
        }
    }

    private String getApiSource(feign.Response response) {
        if (response.request().url().contains(FGAD_API_PATTERN)) {
            return FGAD_API_ERROR;
        }

        if (response.request().url().contains(CICS_API_PATTERN)) {
            return CICS_API_ERROR;
        }

        return API_ERROR;
    }
}
