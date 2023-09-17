package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMetadataLocationResponse {

    private String uuid;

    private String docObjectId;

    @Schema(description = "document creation date", format = "date")
    private String docCreationDate;

    private boolean clientRestit;

    private FgadDocumentMetadata metadata;
    private DocumentBinder binder;

    private String confidentialLevel;

}
