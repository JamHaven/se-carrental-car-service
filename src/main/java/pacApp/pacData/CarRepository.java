package pacApp.pacData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import pacApp.pacModel.Car;
import pacApp.pacModel.CarType;

public interface CarRepository extends MongoRepository<Car, Long>, CarRepositoryExtension {
    List<Car> findByType(CarType type);
	Car findById(long id);
}
