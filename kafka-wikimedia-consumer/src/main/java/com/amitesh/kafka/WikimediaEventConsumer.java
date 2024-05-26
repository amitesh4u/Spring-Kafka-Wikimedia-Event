package com.amitesh.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaEventConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventConsumer.class);

  /**
   * Consumer for given topic
   *
   * @param record Consumer Record fetched from Server
   */
  @KafkaListener(id = "${kafka.consumer.wikimedia.group-id}", topics = "${kafka.wikimedia.event.topic}")
  public void consumeMessageWithConsumerRecord(final ConsumerRecord<String, String> record) {
    LOGGER.info(
        "Consumer Record Message {} received from Topic {} | Partition {} | Offset {} at {}",
        record.value(), record.topic(), record.partition(), record.offset(), record.timestamp());
  }

}
