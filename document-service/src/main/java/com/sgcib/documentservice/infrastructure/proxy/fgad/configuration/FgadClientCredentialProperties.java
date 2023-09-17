package com.sgcib.documentservice.infrastructure.proxy.fgad.configuration;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FgadClientCredentialProperties {
    private String accessTokenUri;
    private String clientId;
    private String clientSecret;
    private List<String> scopes = new ArrayList<>();
}
