package tutor.com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tutor.com.demo.model.WineModel;
import tutor.com.demo.repository.WineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WineServices {

    @Autowired
    WineRepository wineRepository;

    /*
    Basic Operations

    Create          Save            Post
    Read            Get(S/P)        Get
    Update          Save            Put
    Delete          Delete          Delete
    */

    // save, findById, findAll, edit, delete

    public String saveWine(WineModel wine) {
        wineRepository.save(wine);
        return "Wine saved";
    }

    public WineModel findWineById(Integer id) {
//        Optional<WineModel> optionalWine = wineRepository.findById(id);
//        if (optionalWine.isPresent()) {
//            return optionalWine.get();
//        } else return null;
        return wineRepository.findById(id).get();
    }

    public List<WineModel> findAllWine() {
        return wineRepository.findAll();
    }

    public String deleteWineById(Integer id) {
//        wineRepository.delete(findWineById(id));
        Optional<WineModel> wineToDelete = wineRepository.findById(id);
        if (wineToDelete.isPresent()) {
            wineRepository.deleteById(id);
            return "Wine id: " + id + " deleted.";
        } else {
            return "Wine id: " + id + " not found.";
        }
    }

    public String editWine(WineModel wineWithEdits, Integer id) {
        Optional<WineModel> wineToEdit = wineRepository.findById(id);
        if (wineToEdit.isPresent()) {
            wineToEdit.get().setCountry(wineWithEdits.getCountry());
            wineToEdit.get().setType(wineWithEdits.getType());
            wineToEdit.get().setYear(wineWithEdits.getYear());
            return null;
        }
        return null;
    }
}
