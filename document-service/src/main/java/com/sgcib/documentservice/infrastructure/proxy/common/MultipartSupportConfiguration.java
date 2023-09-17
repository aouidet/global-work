package com.sgcib.documentservice.infrastructure.proxy.common;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;


public class MultipartSupportConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverter;

    public Encoder multipartFormatEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverter));
    }
}
