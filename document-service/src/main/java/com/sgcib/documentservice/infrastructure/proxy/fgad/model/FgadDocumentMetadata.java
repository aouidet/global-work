package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FgadDocumentMetadata {

    @NotNull(message = "Type of document must not be null")
    @Size(min = 1, max = 6, message = "Type of document must be between {min} and {max} characters long")
    private String docType;

    private String businessRef;

    private String clientRef;
}
