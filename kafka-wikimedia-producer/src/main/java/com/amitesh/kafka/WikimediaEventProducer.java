package com.amitesh.kafka;

import com.launchdarkly.eventsource.EventSource;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikimediaEventProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value(value = "${kafka.wikimedia.event.topic}")
  private String topic;

  @Value(value = "${wikimedia.event.url}")
  private String wikimediaUrl;

  public WikimediaEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage() throws InterruptedException {
    WikimediaEventHandler eventHandler = new WikimediaEventHandler(kafkaTemplate, topic);

    EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(wikimediaUrl));
    try (EventSource eventSource = builder.build()) {
      eventSource.start();
      TimeUnit.SECONDS.sleep(60);
    }

  }
}
