package ro.msg.learning.shop.model;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Revenue extends BaseEntity{
    @ManyToOne
    Location locationrevenue;
    LocalDate date;
    BigDecimal sum;
}
