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
    Integer id;
    Timestamp createdAt;
    String city;
    String country;
    String street;
    List<QuantityIdProduct> products;

}
