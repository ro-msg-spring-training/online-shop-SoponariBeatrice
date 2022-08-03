package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "stocks")
@ToString(exclude = {"stocks","orders", "revenues"})
public class Location extends BaseEntity{
    String name;
    String country;
    String city;
    String county;
    String street;
    @OneToMany(mappedBy = "location")
    Set<Stock> stocks;
    @OneToMany(mappedBy = "shippedfrom")
    Set<OrderE> orders;
    @OneToMany(mappedBy = "locationrevenue")
    Set<Revenue> revenues;
}
