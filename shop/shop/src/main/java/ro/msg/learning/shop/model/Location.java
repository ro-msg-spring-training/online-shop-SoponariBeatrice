package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "stocks")
@NoArgsConstructor
@ToString(exclude = {"stocks","orders", "revenues"})
public class Location extends BaseEntity{
    private String name;
    private String country;
    private String city;
    private String county;
    private String street;
    @OneToMany(mappedBy = "location")
    private Set<Stock> stocks;
    @OneToMany(mappedBy = "shippedfrom")
    private Set<OrderE> orders;
    @OneToMany(mappedBy = "locationrevenue")
    private Set<Revenue> revenues;

    public Location(String name, String country, String city, String county, String street) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.county = county;
        this.street = street;
    }
}
