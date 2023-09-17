package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FgadRequest {

    private String clientId;
    private String irtCode;
    private String perimeter;
    private String domain;
    private String context;
    private String userID;

}
