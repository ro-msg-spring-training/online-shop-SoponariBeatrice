package ro.msg.learning.shop.model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Revenue extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "LOCATIONID")
    Location locationrevenue;
    @Column(name = "DATE")
    LocalDate date;
    @Column(name = "SUM")
    BigDecimal sum;
}
