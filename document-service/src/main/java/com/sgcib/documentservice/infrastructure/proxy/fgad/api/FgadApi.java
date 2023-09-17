package com.sgcib.documentservice.infrastructure.proxy.fgad.api;

import com.sgcib.documentservice.infrastructure.proxy.fgad.model.ContentLocatorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface FgadApi {

    @GetMapping(value = "/v1/{perimeter}/{domain}/documznts/{idDocument}",
            consumes = "multipart/from-data",
            produces = "application/octet-stream")
    ResponseEntity<byte[]> getFile(@RequestHeader(name = "X-sg-irt") String irt,
                                   @PathVariable(name = "perimeter") String perimeter,
                                   @PathVariable(name = "domain") String domain,
                                   @PathVariable(name = "idDocument") String idDocument);


    @GetMapping(value = "/v1/{perimeter}/{domain}/documents")
    ResponseEntity<byte[]> getDocument(@RequestHeader(name = "X-sg-irt") String irt,
                                   @PathVariable(name = "perimeter") String perimeter,
                                   @RequestParam(name = "mode") String mode,
                                   @RequestParam(name = "businessRef") String businessRef);


    @PostMapping(value = "/v1/{perimeter}/{domain}/documents")
    ResponseEntity<byte[]> createContentLocators(@RequestHeader(name = "X-sg-irt") String irt,
                                       @PathVariable(name = "perimeter") String perimeter,
                                       @RequestParam(name = "mode") String mode,
                                       @RequestBody ContentLocatorRequest request);
}
