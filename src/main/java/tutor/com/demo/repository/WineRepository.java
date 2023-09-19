package tutor.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutor.com.demo.model.WineModel;

public interface WineRepository extends JpaRepository <WineModel, Integer> {
}
