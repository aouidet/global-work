package com.sgcib.documentservice.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FgadDocumentMetadata {

    /**
     * Type of document, ex: T00514
     */
    @NotNull(message = "Type document must not be null")
    @Size(min = 1, max = 6, message = "Type document must be between {min} and {max} characters long")
    private String docType;

    /**
     * Business reference (Business Index), ex: GES0007
     */
    @Size(min = 1, max = 32, message = "business reference must be between {min} and {max} characters long")
    private String businessRef;

    @NotNull(message = "reference client must not be null")
    @Size(min = 1, max = 32, message = "reference client must be between {min} and {max} characters long")
    private String clientRef;
}
