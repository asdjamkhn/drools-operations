package com.example.drools_practise.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@ToString
public class IncomingSMS implements Serializable {
    @JsonProperty(value = "LA")
    private String LA;
    private String destination;
    private String source;
    private byte[] message;
    private int messageLength;
    private int optionalParamCount;
    private int messageId;
    private int sequenceNum;
    private String esmClass;
    private String messageEncoding;
    private int sourceTon = -1;
    private int sourceNpi = -1;
    private int destinationTon = -1;
    private int destinationNpi = -1;
    private int priority = -1;
    private int registeredDelivery = -1;

    private String virtual_number;
    private String renewal_period;
    private int balance;
}

