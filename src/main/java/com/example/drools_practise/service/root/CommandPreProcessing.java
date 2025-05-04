package com.example.drools_practise.service.root;

import com.example.drools_practise.dto.IncomingSMS;
import com.example.drools_practise.dto.Request;
import com.example.drools_practise.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommandPreProcessing {

    private final Constants constants;
    private final DNSmsHandlingConfig dnSmsHandlingConfig;
    private final DroolsDecisionService droolsDecisionService;

    public void preProcessing(IncomingSMS incomingSMS) {

        log.info("IncomingSMS :" + incomingSMS);
        String raw_sms = new String(incomingSMS.getMessage()).toLowerCase();

        if (raw_sms.isBlank()) {
            raw_sms = "help";
        }

        String command = "";
        String[] sms_arr = raw_sms.split("\\s+");

        String channel = "SMS";

        if (raw_sms.length() > 0) {
            command = sms_arr[0].toLowerCase();

        }

        String msgDestination = incomingSMS.getDestination();

        Request request = parseSMS(incomingSMS, channel.toUpperCase(), command);
        log.info("Builder Request ----> {}", request);
        log.info("INFO: origin: {} -- source: {} -- destination: {} ", channel, incomingSMS.getSource(), msgDestination);
        if (constants.getValidShortCodes().contains(msgDestination)) {
            if (dnSmsHandlingConfig.getCommands().containsKey(command)) {

                request.setMethodName(dnSmsHandlingConfig.getCommands().get(command));

                log.info("Final Request Body --> {}", request);
                droolsDecisionService.processRequest(request);
            } else {
                log.warn("command not found");
                request.setMethodName(dnSmsHandlingConfig.getDefaultCommand());
            }
        }
    }

    private Request parseSMS(IncomingSMS sms, String channel, String command) {
        return Request
                .builder()
                .msisdn(sms.getSource())
                .sendSms(false)
                .service(channel)
                .transactionId(sms.getSource() + "_" + System.nanoTime())
                .destination(sms.getDestination())
                .virtualNumber(sms.getVirtual_number())
                .messageBody(new String(sms.getMessage()))
                .renewalPeriod(sms.getRenewal_period())
                .description(command) //message {SUB}
                .build();
    }
}

