package ro.msg.learning.shop.model;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;



@Entity
@Data
public class ProductCategory extends BaseEntity {
    String name;
    String description;
    @OneToMany(mappedBy = "category")
    Set<Product> products;

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductCategory() {

    }


}
