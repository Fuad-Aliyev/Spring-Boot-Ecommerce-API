package com.sf_ecommerce.fncom.config;

import com.sf_ecommerce.fncom.utils.Constants;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.io.IOException;

@Profile(
        Constants.GRPC_PROFILE
)
@Configuration
@EnableCaching
public class CacheConfiguration {
    @Bean
    JCacheCacheManager cacheManager() throws IOException {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager(
                new ClassPathResource("cache/ehcache.xml").getURI(),
                cachingProvider.getDefaultClassLoader());
        MutableConfiguration<Object, Object> configuration = new MutableConfiguration<>();
        configuration.setStoreByValue(true);
        return new JCacheCacheManager(cacheManager);
    }
}
