package com.sgcib.documentservice.infrastructure.proxy.fgad.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Data
public class FgadBddfConfiguration {

    @Value("")
    private String clientId;

    @Value("")
    private String imexBddfIrt;
}
