package com.amitesh.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Value(value = "${kafka.wikimedia.event.topic}")
  private String topic;


  /**
   * The NewTopic bean causes the topic to be created on the broker; it is not needed if the topic
   * already exists.
   *
   * @return NewTopic
   */
  @Bean
  public NewTopic testTopic1() {
    return TopicBuilder.name(topic)
        .partitions(2)
        .replicas(1)
        .build();
  }

}
