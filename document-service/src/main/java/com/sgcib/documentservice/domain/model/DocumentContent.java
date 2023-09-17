package com.sgcib.documentservice.domain.model;

import com.sgcib.documentservice.infrastructure.model.DocumentMetadataLocatorResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentContent {

    private byte[] file;
    private DocumentMetadataLocatorResponse metadataLocatorResponse;
}
