package com.sf_ecommerce.fncom.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import static com.sun.org.apache.xalan.internal.xsltc.dom.CollatorFactoryBase.DEFAULT_LOCALE;
import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
public class MessageConfiguration {

//    @Bean(LABELS_MESSAGES_BEAN_NAME)
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename(LABELS_PATH);
//        messageSource.setDefaultEncoding(UTF_8.name());
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.setDefaultLocale(DEFAULT_LOCALE);
//        return messageSource;
//    }
//
//    @Bean(EMAIL_TEMPLATES_BEAN_NAME)
//    public MessageSource emailTemplateBeanName() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename(EMAIL_TEMPLATES_PATH);
//        messageSource.setDefaultEncoding(UTF_8.name());
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.setDefaultLocale(DEFAULT_LOCALE);
//        return messageSource;
//    }
}
