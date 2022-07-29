package ro.msg.learning.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Supplier extends BaseEntity{
    String name;
    @OneToMany(mappedBy = "supplier")
    Set<Product> products;

    public Supplier(String name) {
        this.name = name;
    }

}
