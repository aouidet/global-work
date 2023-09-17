package com.sgcib.documentservice.infrastructure.proxy.fgad.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentBinder {

    /**
     * identification of plies reattachment
     */
    private String binderId;

    /**
     * the doc minType
     */
    private String binderDocId;

    /**
     * rang of plies of reattachment
     */
    private String binderRank;

}
