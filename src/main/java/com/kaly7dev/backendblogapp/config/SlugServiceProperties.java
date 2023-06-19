package com.kaly7dev.backendblogapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "slug.service")
@Component
@Data
public class SlugServiceProperties {
   private String url;
}
