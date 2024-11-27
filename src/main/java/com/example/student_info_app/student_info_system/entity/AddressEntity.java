package com.example.student_info_app.student_info_system.entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Entity
@Table(name = "tbl_address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addrId;
    @Column(name = "country_name")
    private String country;
    @Column(name = "state_name")
    private String state;
    @Column(name = "city_name")
    private String city;
    @Column(name = "district_name")
    private String district;
    @Column(name = "pin_code")
    private String pin;

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addrId=" + addrId +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
