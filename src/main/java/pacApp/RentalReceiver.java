package pacApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import pacApp.pacData.CarRepository;
import pacApp.pacModel.Car;

public class RentalReceiver {

    private static final Logger log = LoggerFactory.getLogger(RentalReceiver.class);
    @Autowired
    private CarRepository carRepository;

    public RentalReceiver() {
        log.info("instantiated");
    }

    @RabbitListener(queues = "#{autoDeleteCarQueue.name}")
    public void receive(String input) throws InterruptedException {
        log.info("receive: " + input);
        long carId = 0;

        try {
            carId = Long.parseLong(input);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return;
        }

        Car car = this.carRepository.findById(carId);
        log.info(car.toString());
        car.setAvailable(!car.isAvailable());
        log.info(car.toString());
        this.carRepository.save(car);
    }
}
