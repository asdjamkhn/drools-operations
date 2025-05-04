package com.example.drools_practise.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "param")
public class Constants {

    @Value("#{'${param.VALID_SHORT_CODES}'.split(',')}")
    private List<String> validShortCodes;
}
