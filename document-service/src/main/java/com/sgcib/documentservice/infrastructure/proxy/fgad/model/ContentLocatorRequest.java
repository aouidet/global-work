package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentLocatorRequest {

    private int direction;
    private String minType;
    private String fileName;
}
