package com.sgcib.documentservice.infrastructure.proxy.cics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentUpdateRequestDto {

    private String refImex;

    private String cleGed;

    private String externalIdStep;

    private String step;

    private String cleTiers;

    private String documentType;

    private String externalIdDoc;

}
