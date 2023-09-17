package com.sgcib.documentservice.infrastructure.exception;

public enum ErrorCodeEnum {

    DM_400_000001("File format [%s] not allowed"),
    DM_400_000002("File required are emmpty for app [%s]"),
    DM_400_000003("the file cannot be empty"),;

    private final String message;

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
