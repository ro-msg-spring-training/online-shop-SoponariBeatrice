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
}
