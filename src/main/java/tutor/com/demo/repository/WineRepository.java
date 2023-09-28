package tutor.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutor.com.demo.model.WineModel;
@Repository
public interface WineRepository extends JpaRepository <WineModel, Integer> {
}
