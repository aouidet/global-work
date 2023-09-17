package com.sgcib.documentservice.web;

import com.sgcib.documentservice.web.model.DocumentRequest;
import com.sgcib.documentservice.web.model.DocumentSavedResponse;
import com.sgcib.documentservice.web.services.DocumentRequestValidator;
import com.sgcib.documentservice.web.services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Tag(name = "document", description = "sucument management")
@RestController
@Validated
@RequiredArgsConstructor
public class DocumentController {

    private static final String APP_CODE_HEADER = "X-APP-CODE";
    private static final String USER_ID_HEADER = "X-User-ID";
    private static final String API_DOCUMENT_EVENT = "API_DOCUMENTS";
    private static final String APP_CODE_PATTERN = "DTR|ALLNET|EDITRADE";

    private final DocumentService documentService;

    private final DocumentRequestValidator documentRequestValidator;

    @Operation(summary = "save document", description = "description", responses = {@ApiResponse(responseCode = "200", description = "document saved in imex")})
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
    @PreAuthorize("hasAuthority('SCOPE_api.editrade-document-manahement.Write")
    public ResponseEntity<DocumentSavedResponse> saveDocument(@RequestHeader(name = APP_CODE_HEADER) @Pattern(regexp = APP_CODE_PATTERN)
                                                                  @Schema(description = "Application code",
                                                                          required = true,
                                                                          allowableValues = {"DTR", "ALLNET", "PETRA", "EDITRADE"})
                                                                          String appCode,

                                                              @RequestHeader(name = USER_ID_HEADER)
                                                              @Schema(description = "userId")
                                                                      String userId,

                                                              @Valid @ModelAttribute DocumentRequest documentRequest, Errors errors) {

        this.documentRequestValidator.validate(appCode, documentRequest, errors);
        return this.documentService.saveDocument(documentRequest, userId, appCode);
    }
}
