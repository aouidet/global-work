package com.sgcib.documentservice.infrastructure.proxy.fgad.api;

import com.sgcib.documentservice.infrastructure.proxy.common.MultipartSupportConfiguration;
import com.sgcib.documentservice.infrastructure.proxy.fgad.configuration.FgadBddfClientCredentialsConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${fgad-bddf-api-name}",
        url = "${fgad-bddf-api.url}",
        configuration = {FgadBddfClientCredentialsConfiguration.class, MultipartSupportConfiguration.class})
public interface FgadBddfApiClientCredentials extends FgadApi {
}
