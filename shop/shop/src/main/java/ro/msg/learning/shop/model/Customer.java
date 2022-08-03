package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Customer extends BaseEntity{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
