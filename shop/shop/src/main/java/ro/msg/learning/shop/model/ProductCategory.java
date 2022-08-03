package ro.msg.learning.shop.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
public class ProductCategory extends BaseEntity {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
