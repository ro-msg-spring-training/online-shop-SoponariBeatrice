package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Location extends BaseEntity{
    String name;
    String country;
    String city;
    String county;
    String street;
    @OneToMany(mappedBy = "location")
    Set<Stock> stocks;
    @OneToMany(mappedBy = "shippedfrom")
    Set<Order> orders;
    @OneToMany(mappedBy = "locationrevenue")
    Set<Revenue> revenues;
}
