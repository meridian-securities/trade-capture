package com.meridian.tradecapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradePublisher {

    private static final Logger log = LoggerFactory.getLogger(TradePublisher.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void publishTrade(String tradeJson) {
        log.info("Publishing trade to TRADE.NEW queue");
        jmsTemplate.convertAndSend("TRADE.NEW", tradeJson);
        log.info("Trade published successfully");
    }
}
