package com.sgcib.documentservice.domain.service;

import com.sgcib.documentservice.domain.model.DocumentFormatEnum;
import com.sgcib.documentservice.infrastructure.proxy.cics.api.CicsApiClient;
import com.sgcib.documentservice.infrastructure.proxy.cics.model.CommonResponseDto;
import com.sgcib.documentservice.infrastructure.proxy.cics.model.CustomDetailsDto;
import com.sgcib.documentservice.infrastructure.proxy.cics.model.DocumentInsertRequestDto;
import com.sgcib.documentservice.infrastructure.proxy.cics.model.DocumentUpdateRequestDto;
import com.sgcib.documentservice.infrastructure.util.StringShortenUtil;
import com.sgcib.documentservice.web.model.DocumentRequest;
import com.sgcib.documentservice.web.model.DocumentSavedResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentDataService {

    private final CicsApiClient cicsApiClient;

    public boolean persistDocumentDAta(DocumentRequest request,
                                       String userId,
                                       String appCode,
                                       DocumentSavedResponse documentSavedResponse,
                                       CustomDetailsDto customDetailsDto) {
        try {
            if(StringUtils.isNotEmpty(documentSavedResponse.getCleGed()) &&
            StringUtils.equalsIgnoreCase(DocumentFormatEnum.OGN.name(), documentSavedResponse.getDocumentFormat())) {
                return this.updateOriginalDocument(request, customDetailsDto)
                        .getStatusCode()
                        .is2xxSuccessful();
            } else {
                // save other format with ref imex (insert document)
                return  this.saveDocumentIntoPetra(request,customDetailsDto, userId, appCode, documentSavedResponse)
                        .getStatusCode()
                        .is2xxSuccessful();
            }
        } catch (Exception exception) {
            System.out.println(String.format("Error when persist document data : [%s]", exception.getMessage()));
            return false;
        }
    }

    private ResponseEntity<DocumentInsertRequestDto> saveDocumentIntoPetra(DocumentRequest request, CustomDetailsDto customDetailsDto, String userId, String appCode, DocumentSavedResponse documentSavedResponse) {

        var documentInsertRequestDto = DocumentInsertRequestDto.builder()
                .cleGed(request.getCleGed())
                // TODO to complete
                .build();
        return this.cicsApiClient.saveDocument(documentInsertRequestDto);
    }

    public ResponseEntity<CommonResponseDto> updateDocument(DocumentUpdateRequestDto request, CustomDetailsDto customDetailsDto){

        try {
            request.setCleTiers(customDetailsDto.getCleTiers());
            // add logger
            return this.cicsApiClient.updateDocument(request);
        } catch (Exception exception) {
            // logger
            return ResponseEntity.of(Optional.empty());
        }
    }

    private ResponseEntity<CommonResponseDto> updateOriginalDocument(DocumentRequest request, CustomDetailsDto customDetailsDto) {
        var documentUpdateRequestDto = DocumentUpdateRequestDto.builder()
                .externalIdStep(String.valueOf(request.getExternalStepId()))
                .externalIdDoc(request.getExternalIdDoc())
                .cleGed(request.getCleGed())
                .build();
        return this.updateDocument(documentUpdateRequestDto, customDetailsDto);
    }

    private String getUserComments(String userComment) {
        return StringUtils.isNotEmpty(userComment) ? StringShortenUtil.cleanContentForCharset(userComment, StringShortenUtil.charsetEBCDIC) : StringUtils.EMPTY;
    }
}
