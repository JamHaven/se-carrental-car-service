package pacApp.pacData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pacApp.pacModel.Car;

import java.util.List;

@Component
@Slf4j
public class InitTestData implements CommandLineRunner {

  	private static final Logger log = LoggerFactory.getLogger(InitTestData.class);
  	@Autowired
  	private CarRepository repository;

	@Override
	public void run(String... args) throws Exception {
		CarFactory carFactory = new CarFactory();
		List<Car> carList = carFactory.buildCars();

		int index = 0;
		long id = 1L;
		while (index < (carList.size()/4)*3) {
			Car car = carList.get(index);
			car.setId(id);
			repository.save(car);

			index++;
			id++;
		}
	}
}
