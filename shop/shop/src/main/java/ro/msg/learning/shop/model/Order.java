package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Order extends BaseEntity{
    @ManyToOne
    Location shippedfrom;
    @ManyToOne
    Customer customer;

    @OneToMany(mappedBy = "order")
    Set<OrderDetail> orderDetails;
}
