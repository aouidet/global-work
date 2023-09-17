package com.sgcib.documentservice.infrastructure.proxy.cics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomDetailsDto {

    private String cleTiers;
    private String cifId;
    private String customType;
}
