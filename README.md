

# Spring Boot Kafka

![Java CI with Maven](https://github.com/gcalsolaro/spring-boot-kafka/workflows/Java%20CI%20with%20Maven/badge.svg)
> **Sample application using Apache Kafka as Message Broker powered by Spring Security**


## Table of Contents

   * [Spring Boot Kafka](#spring-boot-kafka)
      * [Architecture](#architecture)
      * [Prerequisites](#prerequisites)
      * [Running Instructions](#running-instructions)
      

## Architecture

The technology stack used is provided by Spring, in particular:

* **_Spring Boot_** - 2.1.9.RELEASE
* **_Spring Kafka_** - 2.2.9.RELEASE

## Prerequisites
* **_JDK 8_** - Install JDK 1.8 version
* **_Maven_** - Download latest version
* **_Apache Kafka_** - kafka_2.12-x

## Running Instructions

 - Start **Zookeeper Server** "*bin/zookeeper-server-start.sh*"
 - Start **Kafka Server** "*bin/kafka-server-start.sh*"
 - Create **Topic 1** "*kafka-topics.sh--create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic argomentoUno*"
 - Create **Topic 2** "*kafka-topics.sh--create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic argomentoDue*"
 - Send message. Example [http://localhost:8083/kafka/publish/ciao](http://localhost:8083/kafka/publish/cazzi)
