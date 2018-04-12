package com.nondo.maven.conf;

import com.nondo.maven.conf.impl.GBKCondition;
import com.nondo.maven.conf.impl.GBKEncodingConvertor;
import com.nondo.maven.conf.impl.UTF8Condition;
import com.nondo.maven.conf.impl.UTF8EncodingConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncodingConvertorConfiguration {
    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConvertor createUTF8Convertor(){
        return new UTF8EncodingConvertor();
    }

    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvertor createGBKConvertor(){
        return new GBKEncodingConvertor();
    }
}
