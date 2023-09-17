package com.sgcib.documentservice.infrastructure.proxy.cics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponseDto {

    private  String codeReturn;

    private String codeRaison;

    private String message;

}
