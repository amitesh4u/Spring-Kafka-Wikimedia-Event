package com.amitesh;

import com.amitesh.kafka.WikimediaEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WikimediaProducerApplication { //implements CommandLineRunner {


  public static void main(String[] args) {
    SpringApplication.run(WikimediaProducerApplication.class, args);
  }

//  @Autowired
//  private WikimediaEventProducer producer;
//
//  @Override
//  public void run(String... args) throws Exception {
//    producer.sendMessage();
//  }

  /* We can comment this method and uncomment other code to execute the sendMessage() method during startup */
  @Bean
  public ApplicationRunner runner(WikimediaEventProducer producer) {
    return args -> producer.sendMessage();
  }
}