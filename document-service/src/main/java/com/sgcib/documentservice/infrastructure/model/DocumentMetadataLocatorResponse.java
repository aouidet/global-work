package com.sgcib.documentservice.infrastructure.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMetadataLocatorResponse {

    private String uuid;
    private String docObjectId;
    @Schema(description = "document creation date", format = "date")
    private String docCreationDate;
    private String docCreation;
    private FgadDocumentMetadata fgadDocumentMetadata;
}
