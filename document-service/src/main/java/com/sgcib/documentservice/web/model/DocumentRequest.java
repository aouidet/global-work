package com.sgcib.documentservice.web.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
public class DocumentRequest {

    @NotNull
    @Size(min = 1, max = 3, message = "")
    @Schema(description = "", required = true, example = "002")
    private String entity;

    @NotNull
    @Schema(description = "file content", required = true)
    private MultipartFile file;

    @NotNull
    @Size(min = 3, max = 3, message = "step Type code must be {max} characters long")
    @Schema(description = "step type code", required = true, example = "ISS")
    private String stepType;

    @Size(min = 16, max = 3, message = "step Type code must be {max} characters long")
    @Schema(description = "Cle Ged UUID or Object_id return by EDM (FGAD)", required = true, example = "ISS")
    private String cleGed;

    @Schema(description = "Document format required for digitrade only", example = "OGN")
    private String documentFormat;

    private String externalStepId;

    private String externalIdDoc;

    private String dealNumber;

    private String refMtp;

    @Override
    public String toString() {
        return "DocumentRequest{" +
                "entity='" + entity + '\'' +
                ", file=" + file +
                ", stepType='" + stepType + '\'' +
                '}';
    }
}
