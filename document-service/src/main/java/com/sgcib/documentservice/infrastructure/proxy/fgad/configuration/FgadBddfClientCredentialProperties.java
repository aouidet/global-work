package com.sgcib.documentservice.infrastructure.proxy.fgad.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fgad-bddf-api-security.oauth2.client.client-credentials")
public class FgadBddfClientCredentialProperties extends FgadClientCredentialProperties {
}
