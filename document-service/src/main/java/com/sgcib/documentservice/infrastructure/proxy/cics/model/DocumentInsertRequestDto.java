package com.sgcib.documentservice.infrastructure.proxy.cics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentInsertRequestDto {

    private String refImex;

    private String cleGed;

    private String format;

    private String cleTiers;

    private String step;

}
