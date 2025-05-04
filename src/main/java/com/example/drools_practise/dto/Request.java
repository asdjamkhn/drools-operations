package com.example.drools_practise.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Setter
@Getter
public class Request {
    private String methodName;
    private String msisdn;
    private String destination;
    private String service; // IVR, SMS, USSD, DigitalCampaign, App
    private String language;
    private boolean sendSms;
    private String digit;
    private String transactionId; // unique ID to identify each request
    private String originalRequest;
    private String description;
    private String renewalPeriod;
    private String virtualNumber;
    private String messageBody;
    //    private String commandOrigin;
    private String subMode;
    private String unSubMode;
    private String command;

}

