package com.example.drools_practise.service.root;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "sms")
public class DNSmsHandlingConfig {

    @Value("#{${zongdn.sms.commands}}")
    private Map<String, String> commands;

     private String defaultCommand;
 }

