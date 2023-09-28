package tutor.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutor.com.demo.model.ChefModel;
@Repository
public interface ChefRepository extends JpaRepository <ChefModel, Integer> {

}
