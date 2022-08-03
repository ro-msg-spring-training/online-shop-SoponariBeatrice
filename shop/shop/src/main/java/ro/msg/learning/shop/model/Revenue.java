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
    private Location locationrevenue;
    private LocalDate date;
    private BigDecimal sum;
}
