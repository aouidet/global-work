package com.sgcib.documentservice.infrastructure.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnProperty(name = "cache.enable", havingValue = "true")
public class CachingConfig {

    @Value("${cache.names}")
    public String[] cacheNames;

    @Value("${cache.time-to-leave}")
    private int timeToLeave;

    @Value("${cache.max-size}")
    public int maximumSize;

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(cacheNames) {
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name,
                        CacheBuilder.newBuilder()
                                .expireAfterAccess(timeToLeave, TimeUnit.MINUTES)
                                .build()
                                .asMap(), false);
            }
        };
    }
}
