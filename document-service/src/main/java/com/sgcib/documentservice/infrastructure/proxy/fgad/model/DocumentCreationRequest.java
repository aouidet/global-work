package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreationRequest {

    @NotNull(message = "the UUID of the document must not be null")
    @Size(min = 1, max = 36, message = "uuid must be between {min} and {max} characters long")
    private String uuid;

    private boolean clientRestit = false;

    private boolean probative = false;

    private boolean operAccess = false;

    private String docMimeType;

    private FgadDocumentMetadata metadata;

    private String appCode;

    @Pattern(regexp = "c1|c2|c3", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String confidentialLevel = "c1";

}
