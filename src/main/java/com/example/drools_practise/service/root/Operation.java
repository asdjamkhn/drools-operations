package com.example.drools_practise.service.root;

import com.example.drools_practise.dto.Request;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Operation {
    public abstract void run(Request request);

    public static boolean preChecks(Request request) {

        if (request.getMsisdn() == null) {
            log.error("[" + request.getTransactionId() + "] MSISDN can not be null:" + request.getMsisdn());
            return false;
        }
        String normalizeMsisdn = normalizeMsisdn(request.getMsisdn());
        if (normalizeMsisdn == null)
        {
            return false;
        }
        request.setMsisdn(normalizeMsisdn);
        validateLanguage(request);
        return true;
    }

    public static String normalizeMsisdn(String msisdn) {
        if (msisdn == null) {
            return msisdn;
        }
        if (msisdn.startsWith("3") && msisdn.length() == 10) {
            return msisdn;
        } else if (msisdn.startsWith("03") && msisdn.length() == 11) {
            return msisdn.substring(1);
        } else if (msisdn.startsWith("92") && msisdn.length() == 12) {
            return msisdn.substring(2);
        } else if (msisdn.startsWith("+92") && msisdn.length() == 13) {
            return msisdn.substring(3);
        } else if (msisdn.startsWith("0092") && msisdn.length() == 14) {
            return msisdn.substring(4);
        } else {
            return null;
        }
    }

    public static Request validateLanguage(Request request) {
        if (request.getLanguage() == null || request.getLanguage().isEmpty()) {
            request.setLanguage("UR");
        } else {
            request.setLanguage(request.getLanguage().toUpperCase());
        }
        return request;
    }
}
