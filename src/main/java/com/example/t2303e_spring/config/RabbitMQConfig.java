package com.example.t2303e_spring.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "example_queue";
    public static final String EXCHANGE_NAME = "example_exchange";
    public static final String ROUTING_KEY = "example.routing.key";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true); // true để tạo hàng đợi bền vững
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
