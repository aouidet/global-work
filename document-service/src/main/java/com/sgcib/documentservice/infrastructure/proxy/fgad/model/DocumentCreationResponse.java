package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreationResponse {

    private String docUuid;

    private String docObjectId;

    private String docCreationDate;

    /**
     * the attachment fold of the document
     */
    private DocumentBinder binder;
}
