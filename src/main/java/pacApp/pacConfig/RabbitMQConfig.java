package pacApp.pacConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pacApp.CarSender;
import pacApp.RentalReceiver;

@Configuration
public class RabbitMQConfig {

    /*
    @Bean
    public Queue rentalsQueue() {
        return new Queue("rentals");
    } */

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("rentals");
    }

    @Bean
    public RentalReceiver rentalReceiver() {
        return new RentalReceiver();
    }

    @Bean
    public CarSender carSender() {
        return new CarSender();
    }

    @Bean
    public Queue autoDeleteCarQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding rentalBinding(TopicExchange topic, Queue autoDeleteCarQueue){
        return BindingBuilder.bind(autoDeleteCarQueue).to(topic).with("car");
    }
}
