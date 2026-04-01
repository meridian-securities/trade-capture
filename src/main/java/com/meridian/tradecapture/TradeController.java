package com.meridian.tradecapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    private static final Logger log = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    private TradePublisher tradePublisher;

    @PostMapping("/api/trades")
    public ResponseEntity<String> submitTrade(@RequestBody String body) {
        log.info("Received trade submission");
        tradePublisher.publishTrade(body);
        return ResponseEntity.ok("{\"status\":\"accepted\"}");
    }
}
