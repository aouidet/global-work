package com.sgcib.documentservice.infrastructure.proxy.fgad.configuration;

import com.sgcib.documentservice.infrastructure.proxy.SgSignInClient;
import com.sgcib.documentservice.infrastructure.proxy.common.SgSignInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(value = FgadBddfClientCredentialProperties.class)
@EnableOAuth2Client
public class FgadBddfClientCredentialsConfiguration {

    @Autowired
    private FgadBddfClientCredentialProperties fgadBddfClientCredentialProperties;

    SgSignInClient getClient() {
        return new SgSignInClient(
                this.fgadBddfClientCredentialProperties.getClientId(),
                this.fgadBddfClientCredentialProperties.getClientSecret(),
                this.fgadBddfClientCredentialProperties.getAccessTokenUri());
    }

    @Bean
    @Qualifier("fgadBddfOauth2FeignInterceptor")
    public SgSignInInterceptor editradeOAuth2FeignRequestInterceptor() {
        return new SgSignInInterceptor(this.fgadBddfClientCredentialProperties, this.getClient());
    }

}
