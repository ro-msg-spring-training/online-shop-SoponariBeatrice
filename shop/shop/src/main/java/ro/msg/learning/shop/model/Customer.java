package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Customer extends BaseEntity{
    @Column(name = "FIRSTNAME")
    String firstName;
    @Column(name = "LASTNAME")
    String lastName;
    @Column(name = "USERNAME")
    String username;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "EMAIL")
    String email;
    @OneToMany(mappedBy = "customer")
    Set<OrderE> orders;
}
