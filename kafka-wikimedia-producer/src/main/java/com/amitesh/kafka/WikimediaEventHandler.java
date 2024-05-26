package com.amitesh.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaEventHandler implements EventHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventHandler.class);

  private final KafkaTemplate<String, String> kafkaTemplate;

  private final String topic;

  public WikimediaEventHandler(final KafkaTemplate<String, String> kafkaTemplate, final String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  @Override
  public void onOpen() {
    // Do Nothing
    LOGGER.info("OnOpen");
  }

  @Override
  public void onClosed() {
    // Do Nothing
    LOGGER.info("OnClosed");
  }

  @Override
  public void onMessage(String s, MessageEvent messageEvent) {
    String eventData = messageEvent.getData();
    LOGGER.info("Message Event data {}", eventData);
    kafkaTemplate.send(topic, eventData);
  }

  @Override
  public void onComment(String s) {
    // Do Nothing
    LOGGER.info("OnComment");
  }

  @Override
  public void onError(Throwable throwable) {
    // Do Nothing
    LOGGER.info("OnError");
  }
}
