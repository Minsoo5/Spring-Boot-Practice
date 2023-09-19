package tutor.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutor.com.demo.model.ChefModel;
import tutor.com.demo.services.ChefServices;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/chef")
@CrossOrigin("http://localhost:3000")
public class ChefController {

    @Autowired
    ChefServices chefServices;
    @PostMapping("/add")
    public String addChef(@RequestBody ChefModel chef) {
        return chefServices.saveChef(chef);
    }

    @GetMapping("/all")
    public List<ChefModel> getAllChefs() {
        return chefServices.findAllChefs();
    }

    @DeleteMapping("/{id}")
    public String deleteChefById(@PathVariable Integer id) {
        return chefServices.deleteChefById(id);
    }

    @PutMapping("/{id}")
    public String editChefsById(@PathVariable Integer id, @RequestBody ChefModel chefWithEdits) {
        return chefServices.editChefById(id, chefWithEdits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChefModel> getChefById(@PathVariable Integer id) {
        try {
            ChefModel chef = chefServices.findChefById(id);
            return new ResponseEntity<>(chef, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
