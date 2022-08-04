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
    private Location locationrevenue;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "SUM")
    private BigDecimal sum;
}
