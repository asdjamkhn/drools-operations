package com.example.drools_practise.service.root;

import com.example.drools_practise.dto.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@Slf4j
public class ParentSubRaw extends Operation {

    @Override
    public void run(Request request) {
        log.info("Yayy I made it to the subscription module");
    }

//    private void setVnSubMode(VnDetails vn, Boolean subscribeForFree, Request request) {
//
//        if (subscribeForFree) {
//            vn.setSubMode(constants.getSUB_MODE().get(request.getSubMode().toLowerCase()));
//        } else {
//            vn.setSubMode(constants.getSUB_MODE().get(request.getCommandOrigin()));
//        }
//    }
}
