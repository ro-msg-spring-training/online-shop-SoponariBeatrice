package ro.msg.learning.shop.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.QuantityIdProduct;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private Integer id;
    private Timestamp createdAt;
    private String city;
    private String country;
    private String street;
    private List<QuantityIdProduct> products;

}
