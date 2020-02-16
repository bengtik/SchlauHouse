package com.bengtik.smarterhome.hue;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.connectivity.hue")
public class HueConfiguration {

    private String baseUrl;
    private String userName;
}
