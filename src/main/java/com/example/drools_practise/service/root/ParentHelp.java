package com.example.drools_practise.service.root;

import com.example.drools_practise.dto.Request;
import com.example.drools_practise.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ParentHelp extends Operation {

    @Autowired
    private Constants constants;

    //Stereotypes --> Component, Congfiguration

    @Override
    public void run(Request request) {
        log.info("Yayy i made it to help module");
    }
}