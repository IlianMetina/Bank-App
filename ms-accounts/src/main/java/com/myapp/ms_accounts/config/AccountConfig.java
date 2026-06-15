package com.myapp.ms_accounts.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@Data
@ConfigurationProperties(prefix = "ms-accounts")
public class AccountConfig {

    private String name;
    private String message;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activesBranches;
}
