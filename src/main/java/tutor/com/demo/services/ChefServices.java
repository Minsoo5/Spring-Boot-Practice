package tutor.com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutor.com.demo.model.ChefModel;
import tutor.com.demo.repository.ChefRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServices {
    //The class that takes data and manipulates it (business logic)
    @Autowired
    ChefRepository chefRepository;

    /*
    Basic Operations

    Create          Save            Post
    Read            Get(S/P)        Get
    Update          Save            Put
    Delete          Delete          Delete
     */

    public String saveChef(ChefModel chef) {
        //creating a new chef
        chefRepository.save(chef);
        return "chef ID : " + chef.getId() + "has been created.";
    }

    public ChefModel findChefById(Integer id) {
        return chefRepository.findById(id).get();
    }

    public List<ChefModel> findAllChefs() {
        return chefRepository.findAll();
    }

    public String deleteChefById(Integer id) {
        Optional<ChefModel> exist = chefRepository.findById(id);
        if (exist.isPresent()) {
            chefRepository.deleteById(id);
            return "Chef ID: " + id + "has been deleted.";
        }
        return "Chef with that ID" + id + "does not exist.";
    }

    public String editChefById(Integer id, ChefModel chefWithEdits) {
        // A chef exists, I want to update it.
        Optional<ChefModel> exist = chefRepository.findById(id);
        if (exist.isPresent()) {
            if (chefWithEdits.getId() == id) {
                exist.get().setName(chefWithEdits.getName());
                exist.get().setSignatureDish(chefWithEdits.getSignatureDish());
                exist.get().setYearsOfService(chefWithEdits.getYearsOfService());
                return "Updated Chef ID: " + id + "Successfully";
            }
            return "JSON Object not matching Chef ID";
        }
        return "Failed to edit Chef with the ID: " + id;
    }

}
