package com.myapp.ms_accounts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Properties {

    public Properties(String name, String message, String buildVersion, Map<String, String> mailDetails, List<String> activesBranches){
        this.name = name;
        this.message = message;
        this.buildVersion = buildVersion;
        this.mailDetails = mailDetails;
        this.activesBranches = activesBranches;
    }

    private String name;
    private String message;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activesBranches;
}