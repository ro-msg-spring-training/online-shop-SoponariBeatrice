package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Customer extends BaseEntity{
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    @OneToMany(mappedBy = "customer")
    Set<Order> orders;
}
