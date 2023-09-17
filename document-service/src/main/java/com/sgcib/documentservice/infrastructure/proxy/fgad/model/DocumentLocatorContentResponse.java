package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentLocatorContentResponse {

    private String singeUrl;

    private String docUuid;

    private String docObjectId;

    private String downLoadStatus;
}
