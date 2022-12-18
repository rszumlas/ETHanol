package com.rszumlas.parceldone.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic accountTopic() {
        return TopicBuilder.name("account")
                .build();
    }

    @Bean
    public NewTopic shelfTopic() {
        return TopicBuilder.name("shelf")
                .build();
    }

}
