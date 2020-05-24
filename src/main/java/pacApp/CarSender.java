package pacApp;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import pacApp.pacModel.Car;

public class CarSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    //@Autowired
    //private Queue queue;

    public void send(Car car) {
        this.template.convertAndSend(topic.getName(), car.toString());
    }
}
