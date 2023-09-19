package tutor.com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String type;
    String country;
    Integer year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public WineModel() {}
    public WineModel(Integer id, String type, String country, Integer year) {
        this.id = id;
        this.type = type;
        this.country = country;
        this.year = year;
    }



}
