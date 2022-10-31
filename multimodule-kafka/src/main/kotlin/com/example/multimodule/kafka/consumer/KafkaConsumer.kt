package com.example.multimodule.kafka.consumer

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.AcknowledgingMessageListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service

@Service
class KafkaConsumer: AcknowledgingMessageListener<String, String> {

    val logger = KotlinLogging.logger {}

    @KafkaListener(topics = ["test"], groupId = "test-kafka", containerFactory = "kafkaListenerContainsFactory")
    override fun onMessage(data: ConsumerRecord<String, String>, acknowledgment: Acknowledgment?) {
        try {
            logger.info("consume data: $data")
            acknowledgment?.acknowledge()
        } catch (e: Exception) {
            logger.error("consume error: $e")
        }
    }
}
