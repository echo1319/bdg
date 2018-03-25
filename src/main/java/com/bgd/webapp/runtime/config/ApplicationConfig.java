package com.bgd.webapp.runtime.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {
    @Value("${config.cache.seconds}")
    private String cacheSeconds;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
/*
        messageSource.setDefaultEncoding("ISO-8859-7");
*/
        messageSource.setCacheSeconds(Integer.valueOf(cacheSeconds)); //reload messages every 10 seconds
        return messageSource;
    }

}
