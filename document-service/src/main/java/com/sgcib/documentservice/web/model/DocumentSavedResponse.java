package com.sgcib.documentservice.web.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentSavedResponse {

    private String docUuid;

    private String docObjectId;

    @Schema(description = "document data saved into PETR DB")
    private boolean  dataSaved;

    private String cleGed;

    private String documentFormat;
}
