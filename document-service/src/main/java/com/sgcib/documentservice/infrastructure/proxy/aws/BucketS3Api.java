package com.sgcib.documentservice.infrastructure.proxy.aws;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class BucketS3Api {

    @Qualifier("awsRestTemplate")
    private final RestTemplate awsClient;

    public BucketS3Api(RestTemplate awsClient) {
        this.awsClient = awsClient;
    }

    public ResponseEntity<String> putObject(URI signeUrl, MultipartFile file) throws IOException {
        var header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HttpEntity<byte[]> fileEntity = new HttpEntity<>(file.getBytes(), header);
        return this.awsClient.exchange(removeHttpsPort(signeUrl), HttpMethod.GET, fileEntity, String.class);
    }

    public ResponseEntity<byte[]> getObject(URI signeUri) {
        return this.awsClient.exchange(removeHttpsPort(signeUri), HttpMethod.GET, null, byte[].class);
    }

    private URI removeHttpsPort(URI uri) {
        if(uri.getPort() == 443) {
            try {
                return new URI(
                        uri.toString().replace(":443", "")
                );
            } catch (URISyntaxException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return uri;
    }
}
