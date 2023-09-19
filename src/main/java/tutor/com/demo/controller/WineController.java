package tutor.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutor.com.demo.model.WineModel;
import tutor.com.demo.services.WineServices;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/wine")
@CrossOrigin("http://localhost:3000")
public class WineController {

    @Autowired
    WineServices wineServices;

    // Need to post, get, delete, put
    // Create, Get, Delete, Update

    @PostMapping("/add")
    public String addWine(@RequestBody WineModel wine) {
        return wineServices.saveWine(wine);
    }

    @GetMapping("/all")
    public List<WineModel> getAllWine() {
        return wineServices.findAllWine();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WineModel> getWineById(@PathVariable Integer id) {
        try {
            WineModel potentialWine = wineServices.findWineById(id);
            return new ResponseEntity<>(potentialWine, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public String editWineById(@PathVariable Integer id, @RequestBody WineModel wineWithEdits) {
        return wineServices.editWine(wineWithEdits, id);
    }

    @DeleteMapping("/{id}")
    public String deleteWineById(@PathVariable Integer id) {
        return wineServices.deleteWineById(id);
    }


}
