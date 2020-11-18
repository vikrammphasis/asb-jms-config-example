package com.example.servicebusjmsconfig.messaging

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.jms.Message
import javax.jms.TextMessage

@Component
class MessageListener {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    // Receive messages from topic (destination), with subscription (topic subscription in Azure)
    // and use the container factory created in the JmsConfig class.
    @JmsListener(
            destination = "message-topic",
            subscription = "consumer-service",
            containerFactory = "myListenerContainerFactory"
    )
    fun receiveMessage(msg: TextMessage) {
        log.info("Message received: ${msg.text}")
    }
}
