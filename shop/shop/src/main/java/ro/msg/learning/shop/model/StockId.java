package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@NoArgsConstructor
public class StockId implements Serializable {
    private Integer productid;
    private Integer locationid;

    public StockId(Integer productid, Integer locationid) {
        this.productid = productid;
        this.locationid = locationid;
    }
}
