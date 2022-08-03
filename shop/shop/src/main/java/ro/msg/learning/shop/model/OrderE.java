package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name="OrderT")
@ToString(exclude = "orderDetails")
public class OrderE extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="shippedfrom")
    Location shippedfrom;

    @ManyToOne
    @JoinColumn(name="customerid")
    Customer customer;

    Timestamp createdat;
    String city;
    String country;
    String street;

    @OneToMany(mappedBy = "order")
    Set<OrderDetail> orderDetails;

    public OrderE(Timestamp createdAt, String city, String country, String street) {
        this.createdat= createdAt;
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public OrderE() {

    }

}
