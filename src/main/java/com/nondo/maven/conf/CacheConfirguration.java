package com.nondo.maven.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfirguration {
    @Bean
    public Cache createCacheObject(){
        return new Cache();
    }
}
