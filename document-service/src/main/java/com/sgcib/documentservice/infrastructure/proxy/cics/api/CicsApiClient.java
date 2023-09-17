package com.sgcib.documentservice.infrastructure.proxy.cics.api;

import com.sgcib.documentservice.infrastructure.proxy.cics.model.CommonResponseDto;
import com.sgcib.documentservice.infrastructure.proxy.cics.model.DocumentInsertRequestDto;
import com.sgcib.documentservice.infrastructure.proxy.cics.model.DocumentUpdateRequestDto;
import org.springframework.http.ResponseEntity;

public interface CicsApiClient {
    ResponseEntity<CommonResponseDto> updateDocument(DocumentUpdateRequestDto request);

    ResponseEntity<DocumentInsertRequestDto> saveDocument(DocumentInsertRequestDto documentInsertRequestDto);
}
