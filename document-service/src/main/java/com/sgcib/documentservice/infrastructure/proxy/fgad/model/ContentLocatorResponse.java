package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentLocatorResponse {

    private String signeUrl;


    private String uuid;

    private int status;

    @Override
    public String toString() {
        return "ContentLocatorResponse{" +
                " uuid='" + uuid + '\'' +
                ", status=" + status +
                '}';
    }
}
