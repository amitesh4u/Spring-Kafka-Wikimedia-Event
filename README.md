# Spring Boot 3.3 application with Kafka 3.7

The Producer module (say Microservice 1) fetches the event stream from [Wikimedia](https://stream.wikimedia.org/v2/stream/recentchange) and
uploads to Kafka server. The Consumer module (say Microservice 2) consumes those messages from Kafka Server.

# How to execute
* Run the Kafka Broker service at localhost:9092 (or modify properties files)
* Run _WikimediaProducerApplication_ application which fetches data on startup for 60 seconds 
  (can be modified in _WikimediaEventProducer_)
* Run _WikimediaConsumerApplication_ application which fetches data from Kafka server
