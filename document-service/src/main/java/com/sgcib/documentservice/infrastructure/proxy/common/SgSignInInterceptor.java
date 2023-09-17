package com.sgcib.documentservice.infrastructure.proxy.common;

import com.sgcib.documentservice.infrastructure.proxy.SgSignInClient;
import com.sgcib.documentservice.infrastructure.proxy.fgad.configuration.FgadClientCredentialProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class SgSignInInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION = "Authorization";
    private static final String X_IBM_CLIENT_ID = "x-ibm-client-id";
    private static final String SG_SIGNIN_TOKEN_ERROR = "Error to get SgSignIn token : %s";
    private final FgadClientCredentialProperties editradeClientCredentialProperties;
    private final SgSignInClient sgSignInClient;

    public SgSignInInterceptor(FgadClientCredentialProperties editradeClientCredentialProperties, SgSignInClient sgSignInClient) {
        this.editradeClientCredentialProperties = editradeClientCredentialProperties;
        this.sgSignInClient = sgSignInClient;
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            requestTemplate.header(AUTHORIZATION, this.sgSignInClient.getAccessToken());
        } catch (Exception exception) {
            System.out.println(String.format(SG_SIGNIN_TOKEN_ERROR, exception.getMessage()));
        }
        requestTemplate.header(X_IBM_CLIENT_ID, this.editradeClientCredentialProperties.getClientId());
    }
}
