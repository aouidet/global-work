package com.sgcib.documentservice.infrastructure.proxy.fgad.api;

import com.sgcib.documentservice.infrastructure.proxy.fgad.model.FgadRequest;
import com.sgcib.documentservice.infrastructure.proxy.fgad.model.ImexDocInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FgadApiClientService {
    
    private final FgadBddfApiClientCredentials fgadBddfApiClientCredentials;
    
    private final FgadBddfConfiguration fgadBddfConfiguration;

    public FgadApiClientService(FgadBddfApiClientCredentials fgadBddfApiClientCredentials, FgadBddfConfiguration fgadBddfConfiguration) {
        this.fgadBddfApiClientCredentials = fgadBddfApiClientCredentials;
        this.fgadBddfConfiguration = fgadBddfConfiguration;
    }
    
    public byte[] getFile(String externalId, String entity) {
        var fgadRequest = buildFgadRequest(entity, StringUtils.EMPTY);
        return getFgadApiClientByEntity(entity).getFile(
                fgadRequest.getIrtCode(), fgadRequest.getPerimeter(),fgadRequest.getDomain(), externalId
        ).getBody();
    }

    public List<ImexDocInfo> getDocuments(String businessRef) {
        if(StringUtils.isNotEmpty(businessRef)) {
            return new ArrayList<>();
        }
        var entity = businessRef.substring(0, 3);
        var fgadRequest = buildFgadRequest(entity, StringUtils.EMPTY);
        return getFgadApiClientByEntity(entity).getDoculents(
                fgadRequest.getIrtCode(),
                fgadRequest?getFgadPerimeter(),
                fgadRequest.getDomain(),
                FgadParams.MODE,
                businessRef
        ).getBody();
    }

    private FgadRequest buildFgadRequest(String entity, String userId) {
        
        String clientId = getClientIdByEntity(entity);
        String irtCode = getIrtCodeByEntity(entity);
        String context = FgadParams.CUSTOMER_CTX;
        String perimeter = getFgadPerimeter(entity);
        return FgadRequest.builder()
                .clientId(clientId)
                .context(context)
                .irtCode(irtCode)
                .build();
    }

    private String getFgadPerimeter(String entity) {
        return isCdnEntity((entity)
        ? this.fgadAouClient
        : this.fgadBddfApiClient);
    }

    private boolean isCdnEntity(String entity) {
        return StringUtils.isNotEmpty(entity)
                && Arrays.asList(fgadBddfConfiguration.getCdcEntities().contains(entity));
    }

    private String getFgadApiClientByEntity(String entity) {
        return StringUtils.isNotEmpty(entity)
                && Arrays.asList(fgadCdnConfiguration.getCdnEntities()).contains(entity);
    }

    private void publishEvent(String messag) {
        eventLogger.log(new DefaultEvent("FGAD_API", EventFields.LOG_EVENT, Level.INFO).field(EventFields.MESSAGE, message));
    }
}
