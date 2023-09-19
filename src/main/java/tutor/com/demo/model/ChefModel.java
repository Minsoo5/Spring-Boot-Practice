package tutor.com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChefModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    Double yearsOfService;
    String signatureDish;
    public ChefModel(){}

//    public ChefModel(String name, Double yearsOfService, String signatureDish) {
//        this.name = name;
//        this.yearsOfService = yearsOfService;
//        this.signatureDish = signatureDish;
//    }
//
//    public ChefModel(Integer id, String name, Double yearsOfService) {
//        this.id = id;
//        this.name = name;
//        this.yearsOfService = yearsOfService;
//    }

    public ChefModel(Integer id, String name, Double yearsOfService, String signatureDish) {
        this.id = id;
        this.name = name;
        this.yearsOfService = yearsOfService;
        this.signatureDish = signatureDish;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(Double yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public String getSignatureDish() {
        return signatureDish;
    }

    public void setSignatureDish(String signatureDish) {
        this.signatureDish = signatureDish;
    }

}
